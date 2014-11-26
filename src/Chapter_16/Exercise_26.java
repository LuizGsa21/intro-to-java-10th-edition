package Chapter_16;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Simulation: raise flag and play anthem)
 * Write a program that displays a flag rising up,
 * as shown in Figure 15.14. As the national flag rises, play
 * the national anthem. (You may use a flag image and anthem
 * audio file from Listing 16.15.)
 *
 * Created by luizsa on 9/29/14.
 */
public class Exercise_26 extends Application {

    Pane pane = new Pane();

    @Override
    public void start(Stage primaryStage) throws Exception {

        AudioClip audioClip = new AudioClip("file:/Users/luizsa/GitHub/java/intro-to-java-10th-edition/src/audio/us.mp3");
        ImageView imgView = new ImageView(new Image("/image/us.gif"));
        pane.getChildren().addAll(imgView);
        PathTransition pathT = new PathTransition(Duration.seconds(20), new Line(75, 300, 320, 75), imgView);
        pathT.play();
        audioClip.play();

        primaryStage.setScene(new Scene(pane, 400, 400));
        primaryStage.setTitle("Pane");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
