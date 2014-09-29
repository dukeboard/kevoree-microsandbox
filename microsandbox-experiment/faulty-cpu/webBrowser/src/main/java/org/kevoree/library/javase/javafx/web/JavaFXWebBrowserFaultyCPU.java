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
import org.kevoree.annotation.*;
import org.kevoree.api.Context;
import org.kevoree.api.ModelService;
import org.kevoree.api.handler.ModelListenerAdapter;
import org.kevoree.library.javase.javafx.layout.SingleWindowLayout;
import org.kevoree.microsandbox.api.contract.impl.CPUMemoryThroughputContractedImpl;

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
@ComponentType
public class JavaFXWebBrowserFaultyCPU extends CPUMemoryThroughputContractedImpl {

    @Param(defaultValue = "true")
    boolean singleFrame;
    @Param(defaultValue = "http://localhost:9500/")
    String url;
    @Param
    String uselessParameter;

    @KevoreeInject
    ModelService modelService;
    @KevoreeInject
    Context context;

    private Stage localWindow;
    private Tab tab;
    //    private BorderPane root;
    private WebView webView;
    private WebEngine webEngine;

    private boolean initialized;
    private final List<String> messagesToHandle = new ArrayList<String>();
    private final Object wait = new Object();

    private CPUFault fault;

    @Start
    public void start() {
        fault = new CPUFault(2, 23000);
        fault.create();
        synchronized (messagesToHandle) {
            initialized = false;
        }
        modelService.registerModelListener(new ModelListenerAdapter() {
            @Override
            public void modelUpdated() {
                SingleWindowLayout.initJavaFX();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        // This method is invoked on JavaFX thread
                        Scene scene = createScene();
                        if (singleFrame) {
                            tab = new Tab();
                            tab.setText(context.getInstanceName());
                            tab.setContent(scene.getRoot());
                            SingleWindowLayout.getInstance().addTab(tab);
                        } else {
                            localWindow = new Stage();
                            localWindow.setTitle(context.getInstanceName() + "@@@" + context.getNodeName());
                            localWindow.setScene(scene);

                            localWindow.show();
//                    TODO localFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        }
                        webEngine.load(url);
                    }
                });
                modelService.unregisterModelListener(this);
            }
        });
    }

    @Stop
    public void stop() throws InterruptedException {
        fault.destroy();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                // TODO unload javafx stuff
                if (singleFrame) {
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

    @Input
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
