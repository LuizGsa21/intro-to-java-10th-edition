package Chapter_18;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/**
 * (Hilbert curve)
 * The Hilbert curve, first described by German mathematician David Hilbert in 1891,
 * is a space-filling curve that visits every point in a square grid with a
 * size of 2 * 2, 4 * 4, 8 * 8, 16 * 16, or any other power of 2.
 * Write a program that displays a Hilbert curve for the specified order
 * Created by Luiz Arantes Sa on 12/15/14.
 */
public class Exercise_37 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        HilbertCurvePane pane = new HilbertCurvePane();
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    class HilbertCurvePane extends BorderPane {

        private final int UP = 0;
        private final int RIGHT = 1;
        private final int DOWN = 2;
        private final int LEFT = 3;

        Label lblOrder = new Label("Enter Order:");
        TextField tfOrder = new TextField("0");
        Polyline polyline = new Polyline();
        Pane pane = new Pane(polyline);

        private double x1;
        private double y1;
        double length = 10;

        int order;

        HilbertCurvePane() {
            setMinSize(400, 400);

            HBox hBox = new HBox(10, lblOrder, tfOrder);
            hBox.setAlignment(Pos.BASELINE_CENTER);
            hBox.setPadding(new Insets(10));

            tfOrder.setPrefColumnCount(4);
            tfOrder.setAlignment(Pos.BASELINE_RIGHT);
            tfOrder.setOnKeyPressed(e-> {

                if (e.getCode() == KeyCode.ENTER) {
                    try {
                        order = Integer.parseInt(tfOrder.getText());
                    } catch (NumberFormatException ex) {
                        order = 0;
                        tfOrder.setText("0");
                    }
                    draw();
                } else if (e.getCode() == KeyCode.UP) {
                    order = Integer.parseInt(tfOrder.getText()) + 1;
                    tfOrder.setText(order + "");
                    draw();
                }else if (e.getCode() == KeyCode.DOWN) {
                    order = Math.max(Integer.parseInt(tfOrder.getText()) - 1, 0);
                    tfOrder.setText(order + "");
                    draw();
                }
            });
            setBottom(hBox);

            setCenter(pane);
        }

        private void draw() {
            if (order == 0) return;

            polyline.getPoints().clear();
            length = 50 / order;
            x1 = Math.min(getWidth(), getHeight()) - 50;
            y1 = x1;
            polyline.getPoints().addAll(x1, y1);
            draw(order, DOWN);
        }

        private void draw(int order, int direction) {

            if (order == 1) {
                switch (direction) {
                    case UP:
                        move(DOWN);
                        move(RIGHT);
                        move(UP);
                        break;
                    case RIGHT:
                        move(LEFT);
                        move(UP);
                        move(RIGHT);
                        break;
                    case DOWN:
                        move(UP);
                        move(LEFT);
                        move(DOWN);
                        break;
                    case LEFT:
                        move(RIGHT);
                        move(DOWN);
                        move(LEFT);
                        break;
                }

            } else if (order > 1){
                    switch (direction) {
                        case UP:
                            draw(order - 1, LEFT);
                            move(DOWN);
                            draw(order - 1, UP);
                            move(RIGHT);
                            draw(order - 1, UP);
                            move(UP);
                            draw(order - 1, RIGHT);
                            break;
                        case RIGHT:
                            draw(order - 1, DOWN);
                            move(LEFT);
                            draw(order - 1, RIGHT);
                            move(UP);
                            draw(order - 1, RIGHT);
                            move(RIGHT);
                            draw(order - 1, UP);
                            break;
                        case DOWN:
                            draw(order - 1, RIGHT);
                            move(UP);
                            draw(order - 1, DOWN);
                            move(LEFT);
                            draw(order - 1, DOWN);
                            move(DOWN);
                            draw(order - 1, LEFT);
                            break;
                        case LEFT:
                            draw(order - 1, UP);
                            move(RIGHT);
                            draw(order - 1, LEFT);
                            move(DOWN);
                            draw(order - 1, LEFT);
                            move(LEFT);
                            draw(order - 1, DOWN);
                            break;
                    }
                }
        }

        private void move(int direction) {
            ObservableList<Double> list = polyline.getPoints();
            switch (direction) {
                case UP:
                    list.addAll(x1, y1 -= length);
                    break;
                case RIGHT:
                    list.addAll(x1 += length, y1);
                    break;
                case DOWN:
                    list.addAll(x1, y1 += length);
                    break;
                case LEFT:
                    list.addAll(x1 -= length, y1);
                    break;
            }

        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
