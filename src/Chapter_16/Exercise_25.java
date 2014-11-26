package Chapter_16;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by luizsa on 9/29/14.
 */
public class Exercise_25 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        HBox hBoxTFRates = new HBox();
        hBoxTFRates.setSpacing(10);
        hBoxTFRates.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(hBoxTFRates);

        Timeline[] timelines = new Timeline[4];

        TextField[] tfCarRate = new TextField[4];

        for (int i = 0; i < timelines.length; i++) {

            // Car pane
            CarPane carPane = new CarPane(900, 100);
            timelines[i] = new Timeline(
                    new KeyFrame(Duration.millis(10), e -> carPane.moveCar(1)));
            timelines[i].setCycleCount(carPane.getOneCycleDuration());
            timelines[i].play();

            carPane.setStyle("-fx-border-color: black;" +
                    "-fx-border-insets: 5px");
            vBox.getChildren().add(carPane);

            // Top pane
            tfCarRate[i] = new TextField();
            tfCarRate[i].setPrefColumnCount(3);
            tfCarRate[i].setText(timelines[i].getCurrentRate() +"");
            Label lblCarRates = new Label("Car " + (i + 1) + ":", tfCarRate[i]);
            lblCarRates.setContentDisplay(ContentDisplay.RIGHT);
            hBoxTFRates.getChildren().add(lblCarRates);

            // listeners
            final int index = i;
            timelines[i].setOnFinished(e -> {
                carPane.reset();
                timelines[index].play();
            });

            tfCarRate[i].setOnAction(e-> {

                tfCarRate[index].setText(
                        Math.min( Double.parseDouble(tfCarRate[index].getText()), 100) + "") ;
                timelines[index].setRate(
                        Double.parseDouble(tfCarRate[index].getText()));

            });
            tfCarRate[i].setFocusTraversable(false);
        }


        primaryStage.setScene(new Scene(vBox));
        primaryStage.setTitle("Moving Car");
        primaryStage.show();
    }

    private class CarPane extends Pane {

        private double w; // pane width
        private double h; // pane height

        // left Tire x,y and radius
        private double leftTireX; // left tire is the car's drawing start point
        private double leftTireY;
        private double tireRadius;

        Circle[] tires = new Circle[2]; // Index 0, 1 = left and right tire
        Polyline cover = new Polyline();
        ObservableList<Double> points;
        Rectangle base;

        private CarPane(double width, double height){

            // Get width height and measurements for the left tire (starting point)
            w = width;
            h = height;
            leftTireX = w * 0.2;
            leftTireY = h * 0.9;
            tireRadius = h * 0.1;

            // set MIN and MAX width
            setMinWidth(w);
            setMinHeight(h);

            setMaxWidth(w);
            setMaxHeight(h);

            reset(); // draws and adjusts car to starting position
        }

        public void reset() {

            if (points != null)
                points.clear();
            getChildren().clear();
            drawCar();
            moveCar(tireRadius * 13 * -1);
        }

        public void drawCar() {
            for (int i = 0; i < tires.length; i++) {
                tires[i] = new Circle(leftTireX + (i * 4 * tireRadius), leftTireY, tireRadius);
                tires[i].setStroke(Color.BLACK);
                tires[i].setFill(Color.TRANSPARENT);

            }

            double baseX = tires[0].getCenterX() - tires[0].getRadius() * 3;
            double baseY = tires[0].getCenterY() - tires[0].getRadius() * 3;
            base = new Rectangle(baseX, baseY, tireRadius * 10, tireRadius * 2);
            base.setFill(Color.TRANSPARENT);
            base.setStroke(Color.BLACK);

            // draw the car's top cover
            double startX = base.getX() + tireRadius * 2;
            double startY = base.getY();
            double currentX = startX;
            double currentY = startY;

            points = cover.getPoints();

            double distance = tireRadius * 2;
            points.addAll(currentX, currentY); // start point

            currentX += distance;
            currentY -= distance;
            points.addAll(currentX, currentY); // up right

            currentX += distance;
            points.addAll(currentX,currentY); // right

            currentX += distance;
            currentY += distance;
            points.addAll(currentX,currentY); // down right

            points.addAll(startX, startY); // connect to starting point
            cover.setFill(Color.BLUE);

            getChildren().addAll(tires);
            getChildren().add(base);
            getChildren().add(cover);
        }

        private void moveCar(double distance) {

            // tires
            for (Circle c : tires) {
                c.setCenterX(c.getCenterX() + distance);
            }

            base.setX(base.getX() + distance);

            for (int i = 0; i < points.size(); i += 2) {
                points.set(i, points.get(i) + distance);
            }

        }

        public int getOneCycleDuration(){
            return (int)w;
        }
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
