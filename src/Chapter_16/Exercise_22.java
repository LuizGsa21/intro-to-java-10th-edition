package Chapter_16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

/**
 *  (Play, loop, and stop a sound clip) Write a program that meets the following requirements:
 *      ■ Get an audio file from the class directory using AudioClip.
 *      ■ Place three buttons labeled Play, Loop, and Stop, as shown in Figure 16.46a.
 *      ■ If you click the Play button, the audio file is played once. If you click the
 *      Loop button, the audio file keeps playing repeatedly.
 *      If you click the Stop button, the playing stops.
 *
 * Created by luizsa on 9/29/14.
 */
public class Exercise_22 extends Application {

    final String URI = "file:/Users/luizsa/GitHub/java/intro-to-java-10th-edition/src/audio/us.mp3";

    @Override
    public void start(Stage primaryStage) throws Exception {

        AudioClip audioClip = new AudioClip(URI);

        Button btPlay = new Button("Play");
        btPlay.setOnAction(e-> {
            if (audioClip.isPlaying()) {
                audioClip.stop();
            }
            audioClip.setCycleCount(1);
            audioClip.play();
        });
        Button btLoop = new Button("Loop");
        btLoop.setOnAction(e-> {
            if (audioClip.isPlaying()) {
                audioClip.stop();
            }
            audioClip.setCycleCount(AudioClip.INDEFINITE);
            audioClip.play();
        });
        Button btStop = new Button("Stop");
        btStop.setOnAction(e -> audioClip.stop());
        HBox hBox = new HBox(btPlay, btLoop, btStop);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10));

        primaryStage.setScene(new Scene(hBox));
        primaryStage.setTitle("Play audio");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
