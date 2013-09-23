package org.kevoree.library.javase.javafx.layout;

import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 29/08/13
 * Time: 19:15
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public class SingleWindowLayout {
    private static SingleWindowLayout instance = null;
    private static boolean isJavaFXInitialized = false;

    public static SingleWindowLayout getInstance() {
        if (instance == null) {
            instance = new SingleWindowLayout();
        }
        return instance;
    }

    private Stage window;
    private BorderPane borderPane;
    private TabPane tabPane;

    public static void initJavaFX() {
        if (!isJavaFXInitialized) {
            new JFXPanel(); // initializes JavaFX environment to avoid "java.lang.IllegalStateException: Toolkit not initialized"
            isJavaFXInitialized = true;
        }
    }

    private void initWindow() {
        window = new Stage();
        StackPane root = new StackPane();
        window.setScene(new Scene(root));
        borderPane = new BorderPane();
        borderPane.setPrefSize(1024, 768);
        tabPane = new TabPane();
        tabPane.setPrefSize(1024, 768);
        tabPane.setSide(Side.TOP);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        window.show();
//                    TODO localFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    }

    private void releaseWindow() {
        // TODO
    }

    public void addTab(Tab tab) {
        if (tabPane == null || tabPane.getTabs().size() <= 0) {
            initWindow();
        }
        tabPane.getTabs().add(tab);
    }

    public void removeTab(Tab tab) {
        if (tabPane != null && tabPane.getTabs().size() > 0) {
            tabPane.getTabs().remove(tab);
            if (tabPane.getTabs().size() <= 0) {
                releaseWindow();
            }
        }
    }
}
