package Chapter_16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * (Use ScrollBar and Slider)
 *    Write a program that uses scroll bars or sliders
 *    to select the color for a text, as shown in Figure
 *    16.43b. Four horizontal scroll bars are used for selecting
 *    the colors: red, green, blue, and opacity percentages.
 *
 * Created by luizsa on 9/27/14.
 */
public class Exercise_17 extends Application {

    ScrollBar[] scrollBars = new ScrollBar[4];
    Color mColor = Color.RED;
    @Override
    public void start(Stage primaryStage) throws Exception {

        Text text = new Text("Show Colors");

        // Bottom pane
        Label[] labels = new Label[4];
        String[] stringLabels = {"Red", "Green", "Blue", "Opacity"};

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(5));

        gridPane.setAlignment(Pos.CENTER);
        for (int i = 0; i < scrollBars.length; i++) {
            scrollBars[i] = new ScrollBar();
            scrollBars[i].setMin(0);
            if (!stringLabels[i].equals("Opacity")) {
                scrollBars[i].setMax(255);
                scrollBars[i].setValue(255);
            } else {
                scrollBars[i].setMax(1);
                scrollBars[i].setValue(1);
            }
            labels[i] = new Label(stringLabels[i]);
            scrollBars[i].valueProperty()
                    .addListener((obser, old, newV) -> text.setFill(getColor()));

            gridPane.add(labels[i], 0, i);
            gridPane.add(scrollBars[i], 1, i);

        }
        StackPane stackPane = new StackPane(text);
        stackPane.setPrefSize(300, 200);
        BorderPane borderPane = new BorderPane(stackPane);
        borderPane.setBottom(gridPane);

        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("Color Changer");
        primaryStage.show();
    }

    private Color getColor() {
        // r g b o
        double[] rgb = new double[4];
        for (int i = 0; i < rgb.length; i++) {
            rgb[i] = scrollBars[i].getValue();
        }
        return Color.rgb((int)rgb[0], (int)rgb[1], (int)rgb[2], rgb[3]);
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
