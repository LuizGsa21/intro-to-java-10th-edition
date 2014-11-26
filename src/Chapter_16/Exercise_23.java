package Chapter_16;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Create an image animator with audio) Create animation in Figure 16.46b to meet the following requirements:
 *      ■ Allow the user to specify the animation speed in a text field.
 *      ■ Get the number of iamges and image’s file-name prefix from the user.
 *      For example, if the user enters n for the number of images and L for the
 *      image prefix, then the files are L1.gif, L2.gif, and so on, to Ln.gif.
 *      Assume that the images are stored in the image directory, a subdirectory of
 *      the program’s class directory. The animation displays the images one after the other.
 *      ■ Allow the user to specify an audio file URL. The audio is played while the
 *      animation runs.
 *
 * Created by luizsa on 9/29/14.
 */
public class Exercise_23 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        TextAnimationPane pane = new TextAnimationPane();


        primaryStage.setScene(new Scene(pane, 575, 600));
        primaryStage.setTitle("Text Animation");
        primaryStage.show();
    }

    private class TextAnimationPane extends BorderPane {

        Button btStartAnimation = new Button("Start Animation");

        long animationSpeed;
        int numOfImages;
        int currentImgNum = 1;
        String url;
        String prefix;
        String imgDir = "/image/";
        String imgExtension = ".gif";

        Timeline timeline = null;

        StackPane centerPane = new StackPane();
        TextAnimationPane() {

            setCenter(centerPane);

            HBox topPane = new HBox(btStartAnimation);
            topPane.setAlignment(Pos.CENTER_RIGHT);
            setTop(topPane);

            GridPane bottomPane = new GridPane();
            bottomPane.setPadding(new Insets(5));
            bottomPane.setHgap(5);

            Label lblInfo = new Label("Enter information for animation");
            bottomPane.add(lblInfo, 0, 0);

            TextField tfAnimationSpeed = new TextField();
            tfAnimationSpeed.setPrefColumnCount(30);
            Label lblAnimationSpeed = new Label("Animation Speed");
            bottomPane.add(lblAnimationSpeed, 0, 1);
            bottomPane.add(tfAnimationSpeed, 1, 1);

            TextField tfImagePrefix = new TextField();
            tfImagePrefix.setPrefColumnCount(30);
            Label lblImagePrefix = new Label("Image file prefix");
            bottomPane.add(lblImagePrefix, 0, 2);
            bottomPane.add(tfImagePrefix, 1, 2);

            TextField tfNumberOfImages = new TextField();
            tfNumberOfImages.setPrefColumnCount(30);
            Label lblNumberOfImages = new Label("Number of Images");
            bottomPane.add(lblNumberOfImages, 0, 3);
            bottomPane.add(tfNumberOfImages, 1, 3);

            TextField tfAudioFileUrl = new TextField();
            tfAudioFileUrl.setPrefColumnCount(30);
            Label lblAudioFileUrl = new Label("Audio file URL");
            bottomPane.add(lblAudioFileUrl, 0, 4);
            bottomPane.add(tfAudioFileUrl, 1, 4);

            setBottom(bottomPane);

            btStartAnimation.setOnAction(e -> {
                animationSpeed = Long.parseLong(tfAnimationSpeed.getText().trim());
                prefix = tfImagePrefix.getText().trim();
                numOfImages = Integer.parseInt(tfNumberOfImages.getText());
                url = tfAudioFileUrl.getText();
                initTimeline();
            });
        }

        private void initTimeline(){
            if (timeline != null) {
                timeline.stop();
                timeline = null;
                currentImgNum = 1;
            }

            timeline = new Timeline(
                    new KeyFrame(Duration.millis(animationSpeed), e-> nextImage()));

            MediaPlayer mp = new MediaPlayer(new Media(url));
            mp.play();
            mp.setCycleCount(MediaPlayer.INDEFINITE);
            timeline.setOnFinished(event -> mp.stop());

            timeline.setCycleCount(numOfImages);
            timeline.play();
        }

        private void nextImage(){
            centerPane.getChildren().clear();
            centerPane.getChildren().add(
                    new ImageView(new Image(imgDir + prefix + currentImgNum++ + imgExtension)));
        }


    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
