package Chapter_16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * (Revise Listing 16.14 MediaDemo.java)
 * Add a slider to enable the user to set the current time for
 * the video and a lbl to display the current time and the total
 * time for the video. As shown in Figure 16.47a, the total time is
 * 5 minutes and 3 seconds and the current time is 3 minutes and 58
 * seconds. As the video plays, the slider value and current time
 * are continuously updated.
 * Created by luizsa on 9/29/14.
 */
public class Exercise_24 extends Application {

    private static final String MEDIA_URL =
            "http://cs.armstrong.edu/liang/common/sample.mp4";

    Slider slTime = new Slider();

    private String totalTime = "";
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        Button playButton = new Button("Play", new ImageView(new Image("image/right.gif")));
        playButton.setOnAction(e -> {

            if (playButton.getText().equals("Play") || playButton.getText().equals("Paused")) {
                mediaPlayer.play();
                totalTime = getTimeFormat(mediaPlayer.getStopTime().toMillis());
                slTime.setMax(mediaPlayer.getStopTime().toMillis());
                playButton.setText("Playing");
            } else {
                mediaPlayer.pause();
                playButton.setText("Paused");
            }
        });


        Button rewindButton = new Button("Replay");
        rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));

        Slider slVolume = new Slider();
        slVolume.setPrefWidth(100);
        slVolume.setMaxWidth(Region.USE_PREF_SIZE);
        slVolume.setMinWidth(30);
        slVolume.setValue(50);
        mediaPlayer.volumeProperty().bind(
                slVolume.valueProperty().divide(100));


        slTime.setPrefWidth(150);

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(2, 0, 2, 0));

        Label lblVideoTime = new Label(getTimeFormat(0), slTime);
        hBox.getChildren().addAll(playButton, rewindButton, new Label("Time"), lblVideoTime,
                new Label("Volume"), slVolume);

        mediaPlayer.currentTimeProperty().addListener(e -> {
            if (!slTime.isValueChanging()) {
                slTime.setValue(mediaPlayer.getCurrentTime().toMillis());
            }

            lblVideoTime.setText(
                    getTimeFormat(mediaPlayer.getCurrentTime().toMillis()) + "/" + totalTime);
        });

        slTime.valueProperty().addListener(ov -> {
            if (slTime.isValueChanging()) {
                mediaPlayer.seek(new Duration(slTime.getValue()));
            }
        });
        BorderPane pane = new BorderPane();
        pane.setCenter(mediaView);
        pane.setBottom(hBox);
        pane.autosize();
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 750, 550);
        primaryStage.setTitle("MediaDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        primaryStage.sizeToScene();
    }

    private String getTimeFormat(double milliseconds) {
        milliseconds /= 1000;
        String seconds =  formatTwoDigits(milliseconds % 60);
        milliseconds /= 60;
        String minutes = formatTwoDigits(milliseconds % 60);
        milliseconds /= 60;
        String hours =  formatTwoDigits(milliseconds % 24);
        return hours + ":" + minutes + ":" + seconds;
    }

    private String formatTwoDigits(double time) {
        int intTime = (int) time;
        return (intTime > 9) ? intTime + "" : "0" + intTime;
    }
    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
