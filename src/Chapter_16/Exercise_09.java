package Chapter_16;

import ToolKit.MyRectangle2D;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * (Geometry: two rectangles intersect?)
 * Write a program that enables the user to specify the location and
 * size of the rectangles and displays whether the two rec- tangles
 * intersect, as shown in Figure 16.39b. Enable the user to point
 * the mouse inside a rectangle and drag it. As the rectangle is
 * being dragged, the rectangle’s center coordinates in the text
 * fields are updated.
 * Created by luizsa on 9/25/14.
 */
public class Exercise_09 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        RectanglePane cPane = new RectanglePane();

        primaryStage.setScene(new Scene(cPane));
        primaryStage.setTitle("Circle Stage");
        primaryStage.show();

    }

    private class RectanglePane extends GridPane {


        Label lblIsIntersect; // Tells whether the circles intersect
        String intersectString = "Two rectangle Intersect? ";

        Rectangle[] rectangles = new Rectangle[2]; // convenience array
        RectangleInfoPane[] rInfoPane = new RectangleInfoPane[2];
        Rectangle r1;
        Rectangle r2;



        private RectanglePane() {

            // Label and circle's default values
            lblIsIntersect = new Label("Two Circles Intersect? No");
            r1 = new Rectangle(30,30,60,45);
            r2 = new Rectangle(60,30,60,45);
            rectangles[0] = r1;
            rectangles[1] = r2;
            // Connect the circles with the text fields;
            for (int i = 0; i < rectangles.length; i++) {
                rInfoPane[i] = new RectangleInfoPane(
                        "MyRec2 Info " + (i + 1) + ":", rectangles[i]);
                rectangles[i].setFill(Color.TRANSPARENT);
                rectangles[i].setStroke(Color.BLACK);

            }
            // Create Pane to hold the two circles
            Pane cPane = new Pane(rectangles);
            cPane.setPadding(new Insets(10));
            cPane.setStyle("-fx-border-color: green");

            // Create Hbox to hold lblIsIntersect and make it center
            HBox topLabelPane = new HBox(lblIsIntersect);
            topLabelPane.setAlignment(Pos.CENTER);

            // add listeners to c1, c2
            for (int i = 0; i < 2; i++) {
                final int index = i;
                rectangles[i].setOnMouseDragged(e -> {
                    rectangles[index].setX(e.getX() - rectangles[index].getWidth() / 2);
                    rectangles[index].setY(e.getY() - rectangles[index].getHeight() / 2);
                    updateStats();
                    rInfoPane[index].update();
                });
            }

            // add nodes to this pane
            add(topLabelPane, 0, 0, 2, 1);
            add(cPane, 0, 1, 2, 1);

            HBox hBoxInfo = new HBox(rInfoPane);
            hBoxInfo.setSpacing(10);
            add(hBoxInfo, 0, 2, 2, 2);

            setVgap(5);
            setHgap(10);
            setPadding(new Insets(10));

            GridPane.setHalignment(topLabelPane, HPos.CENTER);
            GridPane.setHalignment(hBoxInfo, HPos.CENTER);
            autosize();

        }
        // Updates textfields when circles are moved
        private void updateStats() {
            lblIsIntersect.setText(
                    (MyRectangle2D.r1OverLapsR2(r1,r2)) ? intersectString + "Yes" : intersectString + "No");
        }

        private class RectangleInfoPane extends VBox {

            TextField[] mTextFields = new TextField[4];
            private TextField tfX;
            private Label lblX;

            private TextField tfY;
            private Label lblY;

            private TextField tfRecW;
            private Label lblRecW;

            private TextField tfRecH;
            private Label lblRecH;

            Rectangle mRectangle;
            private RectangleInfoPane(String title, Rectangle r) {

                mRectangle = r;
                Label lblTitle = new Label(title);
                HBox titlePane = new HBox(lblTitle);
                titlePane.setAlignment(Pos.CENTER);

                tfX = new TextField();
                mTextFields[0] = tfX;
                tfX.setPrefColumnCount(4);
                tfX.setText(Double.toString(r.getX()));

                lblX = new Label("x:", tfX);
                lblX.setContentDisplay(ContentDisplay.RIGHT);
                HBox xPane = new HBox(lblX);

                tfY = new TextField();
                mTextFields[1] = tfY;
                tfY.setPrefColumnCount(4);
                tfY.setText(Double.toString(r.getY()));
                lblY = new Label("y:", tfY);
                lblY.setContentDisplay(ContentDisplay.RIGHT);
                HBox yPane = new HBox(lblY);

                tfRecW = new TextField();
                mTextFields[2] = tfRecW;
                tfRecW.setPrefColumnCount(4);
                tfRecW.setText(Double.toString(r.getWidth()));
                lblRecW = new Label("width:", tfRecW);
                lblRecW.setContentDisplay(ContentDisplay.RIGHT);
                HBox wPane = new HBox(lblRecW);

                tfRecH = new TextField();
                mTextFields[3] = tfRecH;
                tfRecH.setPrefColumnCount(4);
                tfRecH.setText(Double.toString(r.getWidth()));
                lblRecH = new Label("height:", tfRecH);
                lblRecH.setContentDisplay(ContentDisplay.RIGHT);
                HBox hPane = new HBox(lblRecH);

                getChildren().addAll(titlePane, xPane, yPane, wPane, hPane);

                setStyle("-fx-border-color: black;");

                // set listeners
                for (TextField tf : mTextFields) {
                    tf.setOnAction(e -> updateRecStats());
                }
            }

            private void updateRecStats(){
                mRectangle.setX(Double.parseDouble(tfX.getText()));
                mRectangle.setY(Double.parseDouble(tfY.getText()));
                mRectangle.setWidth(Double.parseDouble(tfRecW.getText()));
                mRectangle.setHeight(Double.parseDouble(tfRecH.getText()));
            }

            private void update() {
                tfX.setText(mRectangle.getX() + "");
                tfY.setText(mRectangle.getY() + "");
                tfRecW.setText(mRectangle.getWidth() + "");
                tfRecH.setText(mRectangle.getHeight() + "");
            }
        }
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
