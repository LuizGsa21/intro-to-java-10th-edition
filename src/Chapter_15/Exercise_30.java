package Chapter_15;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *  (Slide show) Twenty-five slides are stored as image
 *  files (slide0.jpg, slide1 .jpg, . . . , slide24.jpg)
 *  in the image directory downloadable along with the source code in the book.
 *  The size of each image is 800 * 600. Write a pro- gram that automatically
 *  displays the slides repeatedly. Each slide is shown for
 *  two seconds. The slides are displayed in order.
 *  When the last slide finishes, the first slide is redisplayed,
 *  and so on. Click to pause if the animation is currently playing.
 *  Click to resume if the animation is currently paused.
 *
 * Created by luizsa on 9/22/14.
 */
public class Exercise_30 extends Application {

    StackPane slideShow = new StackPane();
    ImageView[] slides;
    int numberOfSlides;
    int currentSlide;

    @Override
    public void start(Stage primaryStage) throws Exception {


        slides = getPictureFiles();
        numberOfSlides = slides.length;

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2), e-> nextSlide()));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        slideShow.setOnMouseClicked(e-> {
            if (timeline.getStatus() == Animation.Status.RUNNING) {
                timeline.pause();
            } else {
                timeline.play();
            }
        });
        slideShow.getChildren().add(slides[currentSlide++]);
        Scene scene = new Scene(slideShow);
        primaryStage.setTitle("Slide Show");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public ImageView[] getPictureFiles() {
        ImageView[] imageView = new ImageView[25];
        for (int i = 0; i < imageView.length; i++) {
            imageView[i] = new ImageView("/image/slide" + i + ".jpg");
        }
        return imageView;
    }

    private void nextSlide() {
        slideShow.getChildren().clear();
        slideShow.getChildren().add(slides[(currentSlide++) % slides.length]);
    }
    public static void main(String[] args) {
        Application.launch(args);
    }


}
