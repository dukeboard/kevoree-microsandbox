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
import org.kevoree.api.service.core.handler.ModelListener;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.library.javase.javafx.layout.SingleWindowLayout;
import org.kevoree.microsandbox.api.contract.FullContracted;

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
public class JavaFXWebBrowserFaultyMemory extends AbstractComponentType implements FullContracted {

    private Stage localWindow;
    private Tab tab;
    //    private BorderPane root;
    private WebView webView;

    private String url;

    private boolean initialized;
    private List<String> messagesToHandle;

    private MemoryFault fault;

    @Start
    public void start() {
        fault = new MemoryFault();
        fault.create();
        initialized = false;
        messagesToHandle = new ArrayList<String>();
        url = getDictionary().get("url").toString();

        getModelService().registerModelListener(new ModelListener() {
            private boolean first = true;

            @Override
            public boolean preUpdate(ContainerRoot currentModel, ContainerRoot proposedModel) {
                return true;
            }

            @Override
            public boolean initUpdate(ContainerRoot currentModel, ContainerRoot proposedModel) {
                return true;
            }

            @Override
            public boolean afterLocalUpdate(ContainerRoot currentModel, ContainerRoot proposedModel) {
                return true;
            }

            @Override
            public void modelUpdated() {
                if (first) {
                    first = false;
                    initializeWebBrowser();
                    getModelService().unregisterModelListener(this);
                }
            }

            @Override
            public void preRollback(ContainerRoot currentModel, ContainerRoot proposedModel) {
            }

            @Override
            public void postRollback(ContainerRoot currentModel, ContainerRoot proposedModel) {
            }
        });
    }

    @Stop
    public void stop() {
        fault.destroy();
        // TODO unload javafx stuff
        if (Boolean.valueOf((String) getDictionary().get("singleFrame"))) {
            SingleWindowLayout.getInstance().removeTab(tab);
        } else {
            localWindow.hide();
        }
    }

    @Update
    public void update() {

    }

    private void initializeWebBrowser() {
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
            }
        });
    }

    @Port(name = "handle")
    public void handle(final Object msg) {
        if (msg instanceof String) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (initialized) {
                        webView.getEngine().executeScript((String) msg);
                    } else {
                        messagesToHandle.add((String) msg);
                    }
                }
            });
        }
    }

    private Scene createScene() {

        webView = new WebView();

        final WebEngine webEngine = webView.getEngine();
        webEngine.load(url);

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

        initialized = true;
        webEngine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<State>() {
                    @Override
                    public void changed(ObservableValue<? extends State> ov,
                                        State oldState, State newState) {
                        if (newState == State.SUCCEEDED) {
                            initialized = true;
                            for (String message : messagesToHandle) {
                                webView.getEngine().executeScript(message);
                            }
                            webEngine.getLoadWorker().stateProperty().removeListener(this);
                        }
                    }
                }
        );

        return scene;
    }

    private void startOutOfKevoree() {
        messagesToHandle = new ArrayList<String>();
        url = getDictionary().get("url").toString();
        initializeWebBrowser();
    }
}
