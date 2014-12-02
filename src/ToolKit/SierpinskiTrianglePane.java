package ToolKit;

import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;

/**
 * SierpinskiTrianglePane
 * 
 * Created by Luiz Arantes Sa on 12/1/14.
 */
public class SierpinskiTrianglePane extends BorderPane {

    TextField tfOrder = new TextField();
    Label lblOrder = new Label("Enter an order:");
    Pane pane = new Pane();

    int order;

    public SierpinskiTrianglePane() {

        tfOrder.setOnAction(e -> {
            order = Integer.parseInt(tfOrder.getText());
            paint();
        });

        HBox hBox = new HBox(20, lblOrder, tfOrder);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.BASELINE_RIGHT);

        tfOrder.setPrefColumnCount(8);

        setCenter(pane);
        setBottom(hBox);
        setPrefWidth(400);
        setPrefHeight(400);

    }

    public void paint() {

        pane.getChildren().clear();

        Point2D p0 = new Point2D(getWidth() * 0.5, getHeight() * 0.1); // top
        Point2D p1 = new Point2D(getWidth() * 0.10, getHeight() * 0.75); // left
        Point2D p2 = new Point2D(getWidth() * 0.90, getHeight() * 0.75); // right

        drawTriangles(order, p0, p1, p2);
    }

    private void drawTriangles(int order, Point2D p0, Point2D p1, Point2D p2) {

        if (order == 0) {
            Polyline poly = new Polyline(
                    p0.getX(), p0.getY(),
                    p1.getX(), p1.getY(),
                    p2.getX(), p2.getY(),
                    p0.getX(), p0.getY()
            );
            pane.getChildren().add(poly);
        } else {
            Point2D p01 = p0.midpoint(p1); // top left
            Point2D p11 = p1.midpoint(p2); // bottom
            Point2D p21 = p2.midpoint(p0); // top right

            drawTriangles(order - 1, p1, p11, p01);
            drawTriangles(order - 1, p2, p11, p21);
            drawTriangles(order - 1, p0, p01, p21);

        }
    }

}
