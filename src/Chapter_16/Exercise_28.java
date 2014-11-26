package Chapter_16;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * (Slide show)
 *      Programming Exercise 15.30 developed a slide show using images.
 *      Rewrite that program to develop a slide show using text files.
 *      Suppose ten text files named slide0.txt, slide1.txt, . . . ,
 *      and slide9.txt are stored in the text direc- tory.
 *      Each slide displays the text from one file. Each slide is
 *      shown for one sec- ond, and the slides are displayed in order.
 *      When the last slide finishes, the first slide is redisplayed,
 *      and so on. Use a text area to display the slide.
 * Created by luizsa on 9/30/14.
 */
public class Exercise_28 extends Application {

    StackPane slideShow = new StackPane();
    TextArea[] slides;

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

    public TextArea[] getPictureFiles() {
        TextArea[] tfStrings = new TextArea[10];

        for (int i = 0; i < tfStrings.length; i++) {
            Scanner input = null;
            String s = "";
            try {
                input = new Scanner(new File("src/Text Files/slide" + i + ".txt"));
                while (input.hasNext()) {
                    s += input.nextLine() + "\n";
                }
                tfStrings[i] = new TextArea(s);
                tfStrings[i].setWrapText(true);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return tfStrings;
    }

    private void nextSlide() {
        slideShow.getChildren().clear();
        slideShow.getChildren().add(slides[(currentSlide++) % slides.length]);
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
