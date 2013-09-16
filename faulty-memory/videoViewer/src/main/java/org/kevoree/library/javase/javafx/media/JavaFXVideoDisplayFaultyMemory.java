package org.kevoree.library.javase.javafx.media;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.library.javase.javafx.layout.SingleWindowLayout;
import org.kevoree.microsandbox.api.contract.FullContracted;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 19/08/13
 * Time: 14:52
 *
 * @author Erwan Daubert
 * @version 1.0
 */
@Library(name = "javafx")
@DictionaryType({
        @DictionaryAttribute(name = "singleFrame", defaultValue = "true", optional = true),
//        @DictionaryAttribute(name = "url", defaultValue = "http://localhost:9500/", optional = true)
})
@Provides({
        @ProvidedPort(name = "media", type = PortType.MESSAGE)
})
@ComponentType
public class JavaFXVideoDisplayFaultyMemory extends AbstractComponentType implements FullContracted {

    private Stage localWindow;
    private Tab tab;
    private Scene scene;

    private Media media;
    private MediaPlayer mediaPlayer;
    private MediaControl mediaControl;

    private MemoryFault fault;

    // TODO add a list of media to display
    // the media port is only use to add media to this list
    // when the user select one the media, this one is played
    private String mediaUrl;

    @Start
    public void start() {
        fault = new MemoryFault();
        fault.create();
        SingleWindowLayout.initJavaFX();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                // This method is invoked on JavaFX thread
                if (Boolean.valueOf((String) getDictionary().get("singleFrame"))) {
                    tab = new Tab();
                    tab.setText(getName());
                    tab.setOnSelectionChanged(new EventHandler<Event>() {
                        @Override
                        public void handle(Event event) {
                            if (tab.isSelected()) {
                                if (mediaUrl != null) {
                                    if (mediaPlayer != null &&
                                            (mediaPlayer.getStatus().equals(MediaPlayer.Status.PAUSED)
                                                    || mediaPlayer.getStatus().equals(MediaPlayer.Status.STOPPED)
                                                    || mediaPlayer.getStatus().equals(MediaPlayer.Status.READY))) {
                                        mediaPlayer.play();
                                    } else {
                                        defineMedia(mediaUrl);
                                    }
                                }
                            } else {
                                if (mediaPlayer != null && mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING)) {
                                    mediaPlayer.pause();
                                }
                            }
                        }
                    });
                    SingleWindowLayout.getInstance().addTab(tab);
                } else {
                    localWindow = new Stage();
                    localWindow.setTitle(getName() + "@@@" + getNodeName());

                    localWindow.show();
//                    TODO localFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                }
                if (mediaUrl != null) {
                    defineMedia(mediaUrl);
                }
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

    @Port(name = "media")
    public void media(final Object o) {
        if (o instanceof String) {
            mediaUrl = (String) o;
            if ((tab != null && tab.isSelected()) || localWindow != null) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        defineMedia(mediaUrl);
                    }
                });

            }
        }
    }

    private void defineMedia(String url) {
        // create media player
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        media = new Media(url);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaControl = new MediaControl(mediaPlayer);
        scene = new Scene(mediaControl);

        if (Boolean.valueOf((String) getDictionary().get("singleFrame"))) {
            tab.setContent(mediaControl);
        } else {
            localWindow.setScene(scene);
        }

        mediaControl.getScene().getStylesheets().add(JavaFXVideoDisplayFaultyMemory.class.getResource("/mediaplayer.css").toExternalForm());

    }
}
