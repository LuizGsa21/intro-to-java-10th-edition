package Chapter_18;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * (Recursive tree)
 *  Write a program to display a recursive tree
 *
 */
public class Exercise_38 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        TreePane pane = new TreePane();
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    class TreePane extends BorderPane {

        Label lblOrder = new Label("Enter Order:");
        TextField tfOrder = new TextField("0");
        Pane pane = new Pane();

        double length = 2;

        int order;

        TreePane() {
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
                } else if (e.getCode() == KeyCode.UP) {
                    order = Integer.parseInt(tfOrder.getText()) + 1;
                    tfOrder.setText(order + "");

                }else if (e.getCode() == KeyCode.DOWN) {
                    order = Math.max(Integer.parseInt(tfOrder.getText()) - 1, 0);
                    tfOrder.setText(order + "");

                }
                draw();
            });
            setBottom(hBox);

            setCenter(pane);
            draw();
        }

        private void draw() {

            pane.getChildren().clear();
            length =  60;
            draw(200, 300, 90, length, order);
        }

        final int ANGLE = 25 ;
        private void draw(double x, double y, double angle, double length, int order) {

            if (order <= 0) return;

            double x2 = x + length * Math.cos(Math.toRadians(angle));
            double y2 = y - length * Math.sin(Math.toRadians(angle));
            double x3 = x + length * Math.cos(Math.toRadians(angle));
            double y3 = y - length * Math.sin(Math.toRadians(angle));
            pane.getChildren().add(new Line(x, y, x2, y2));
            pane.getChildren().add(new Line(x, y, x3, y3));

            draw(x2, y2, angle + ANGLE, length * 0.8, order - 1);
            draw(x3, y3, angle - ANGLE, length * 0.8, order - 1);
        }

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
