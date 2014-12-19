package Chapter_18;

import ToolKit.PaneCollection;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
 * (Koch snowflake fractal)
 * The text presented the Sierpinski triangle fractal. In this exercise, you
 * will write a program to display another fractal, called the Koch snowflake,
 * named after a famous Swedish mathematician.
 * A Koch snowflake is created as follows:
 * <p>
 * 1. Begin with an equilateral triangle, which is considered to be the Koch
 * fractal of order (or level) 0, as shown in Figure 18.14a.
 * 2. Divide each line in the shape into three equal line segments and draw
 * an out- ward equilateral triangle with the middle line segment as
 * the base to create a Koch fractal of order 1, as shown in Figure 18.14b.
 * 3. Repeat Step 2 to create a Koch fractal of order 2, 3, . . . , and so on
 * <p>
 * Created by Luiz Arantes Sa on 12/9/14.
 */
public class Exercise_27 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        KochSnowflakePane pane = new KochSnowflakePane();

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Koch Snowflake");
        primaryStage.show();
    }

    private class KochSnowflakePane extends BorderPane {

        Pane pane = new Pane();
        ObservableList<Node> list = pane.getChildren();

        int order;

        KochSnowflakePane() {

            TextField tfOrder = new TextField();
            tfOrder.setAlignment(Pos.BASELINE_RIGHT);
            tfOrder.setPrefColumnCount(4);
            Label lblOrder = new Label("Enter an order: ");

            tfOrder.setOnKeyPressed(e -> {


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

                } else if (e.getCode() == KeyCode.DOWN) {
                    order = Math.max(Integer.parseInt(tfOrder.getText()) - 1, 0);
                    tfOrder.setText(order + "");

                }
                draw();

            });

            tfOrder.setText("0");
            pane.setPrefSize(400, 400);
            setCenter(pane);
            setMargin(pane, new Insets(100));

            HBox hBox = new HBox(20, lblOrder, tfOrder);
            hBox.setAlignment(Pos.BASELINE_CENTER);
            hBox.setPadding(new Insets(30, 10, 10, 10));
            setBottom(hBox);
            draw();
        }

        private void draw() {
            list.clear();
            double length = 400;

            Line l1 = new Line(200, 0, 200 + length * Math.cos(1 * (Math.PI * 2 / 6)), 0 + length * Math.sin(1 * (Math.PI * 2 / 6)));
            Line l2 = new Line(l1.getEndX(), l1.getEndY(), l1.getEndX() - length, l1.getEndY());
            Line l3 = new Line(l2.getEndX(), l2.getEndY(), l1.getStartX(), l1.getStartY());
            list.addAll(l1, l2, l3);
            draw(order);
        }

        private void draw(int order) {

            if (order == 0)
                return;

            Line[] lines = new Line[list.size()];
            for (int i = 0; i < list.size(); i++) {
                lines[i] = (Line) list.get(i);
            }

            for (Line line : lines) {
                createTriangle(line);
            }
            draw(order - 1);

        }

        private void createTriangle(Line line) {

            double distance = PaneCollection.distance(line) / 3;

            double dy = (line.getStartY() - line.getEndY());
            double dx = (line.getEndX() - line.getStartX());
            double theta = Math.atan2(dy, dx);

            double x1 = line.getStartX() + distance * Math.cos(theta);
            double y1 = line.getStartY() - distance * Math.sin(theta);

            double x2 = line.getEndX() + distance * Math.cos(theta + Math.toRadians(180));
            double y2 = line.getEndY() - distance * Math.sin(theta + Math.toRadians(180));

            double x3 = x2 + distance * Math.cos(theta + Math.toRadians(120));
            double y3 = y2 - distance * Math.sin(theta + Math.toRadians(120));

            Line l1 = new Line(line.getStartX(), line.getStartY(), x1, y1);
            Line l2 = new Line(x2, y2, line.getEndX(), line.getEndY());
            Line l3 = new Line(l1.getEndX(), l1.getEndY(), x3, y3);
            Line l4 = new Line(l3.getEndX(), l3.getEndY(), x2, y2);

            pane.getChildren().remove(line);
            list.addAll(l1, l2, l3, l4);

        }


    }

}
