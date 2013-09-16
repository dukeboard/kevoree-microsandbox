package org.kevoree.library.javase.javafx.web;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.kevoree.ContainerRoot;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.service.handler.ModelListenerAdapter;
import org.kevoree.library.javase.javafx.layout.SingleWindowLayout;
import org.kevoree.microsandbox.api.contract.CPUContracted;
import org.kevoree.microsandbox.api.contract.MemoryContracted;
import org.kevoree.microsandbox.api.contract.ThroughputContracted;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 14/08/13
 * Time: 14:29
 *
 * @author Erwan Daubert
 * @version 1.0
 */
@Library(name = "javafx")
@DictionaryType({
        @DictionaryAttribute(name = "singleFrame", defaultValue = "true", optional = true),
        @DictionaryAttribute(name = "url", defaultValue = "http://localhost:9500/", optional = true)
})
@Provides({
        @ProvidedPort(name = "handle", type = PortType.MESSAGE)
})
@ComponentType
public class JavaFXWebBrowser extends AbstractComponentType implements MemoryContracted, CPUContracted, ThroughputContracted {

    private Stage localWindow;
    private Tab tab;
    //    private BorderPane root;
    private WebView webView;
    private WebEngine webEngine;

    private String url;

    private boolean initialized;
    private final List<String> messagesToHandle = new ArrayList<String>();
    private final Object wait = new Object();

    @Start
    public void start() throws InterruptedException {
        synchronized (messagesToHandle) {
            initialized = false;
        }
        url = getDictionary().get("url").toString();

        getModelService().registerModelListener(new ModelListenerAdapter() {
            @Override
            public void modelUpdated() {
            }

            @Override
            public void preRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
            }

            @Override
            public void postRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
            }
        });

        SingleWindowLayout.initJavaFX();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                // This method is invoked on JavaFX thread
                Scene scene = createScene();
                if (Boolean.valueOf((String) getDictionary().get("singleFrame"))) {
                    tab = new Tab();
                    tab.setText(getName());
                    tab.setContent(scene.getRoot());
                    SingleWindowLayout.getInstance().addTab(tab);
                } else {
                    localWindow = new Stage();
                    localWindow.setTitle(getName() + "@@@" + getNodeName());
                    localWindow.setScene(scene);

                    localWindow.show();
//                    TODO localFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
                synchronized (wait) {
                    wait.notify();
                }
            }
        });
        synchronized (wait) {
            wait.wait();
        }
        getModelService().registerModelListener(new ModelListenerAdapter() {
            @Override
            public void modelUpdated() {

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        webEngine.load(url);
                    }
                });
            }

            @Override
            public void preRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
            }

            @Override
            public void postRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
            }
        });
    }

    @Stop
    public void stop() throws InterruptedException {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                // TODO unload javafx stuff
                if (Boolean.valueOf((String) getDictionary().get("singleFrame"))) {
                    SingleWindowLayout.getInstance().removeTab(tab);
                } else {
                    localWindow.hide();
                }
                synchronized (wait) {
                    wait.notify();
                }
            }
        });
        synchronized (wait) {
            wait.wait();
        }
    }

    @Update
    public void update() {

    }

    @Port(name = "handle")
    public void handle(final Object msg) {
        if (msg instanceof String) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    synchronized (messagesToHandle) {
                        if (initialized) {
                            webView.getEngine().executeScript((String) msg);
                        } else {
                            messagesToHandle.add((String) msg);
                        }
                    }
                }
            });
        }
    }

    private Scene createScene() {

        webView = new WebView();

        webEngine = webView.getEngine();

        final TextField locationField = new TextField(url);
        webEngine.locationProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                locationField.setText(newValue);
            }
        });
        EventHandler<ActionEvent> goAction = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                webEngine.load(locationField.getText().startsWith("http://")
                        ? locationField.getText()
                        : "http://" + locationField.getText());
            }
        };
        locationField.setOnAction(goAction);

        Button goButton = new Button("Go");
        goButton.setDefaultButton(true);
        goButton.setOnAction(goAction);

        // Layout logic
        HBox hBox = new HBox(5);
        hBox.getChildren().setAll(locationField, goButton);
        HBox.setHgrow(locationField, Priority.ALWAYS);

        final VBox vBox = new VBox(5);
        vBox.getChildren().setAll(hBox, webView);
        VBox.setVgrow(webView, Priority.ALWAYS);

        Scene scene = new Scene(vBox);

        webEngine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<State>() {
                    @Override
                    public void changed(ObservableValue<? extends State> ov,
                                        State oldState, State newState) {
                        if (newState == State.SUCCEEDED) {

                            synchronized (messagesToHandle) {
                                initialized = true;
                                for (String message : messagesToHandle) {
                                    webView.getEngine().executeScript(message);
                                }
                                messagesToHandle.clear();
                            }
                            webEngine.getLoadWorker().stateProperty().removeListener(this);
                        }
                    }
                }
        );

        return scene;
    }
}
