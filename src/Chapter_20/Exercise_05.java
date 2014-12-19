package Chapter_20;

import ToolKit.MultipleBounceBall;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * (Combine colliding bouncing balls)
 *  The example in Section 20.7 displays multiple bouncing balls.
 *  Extend the example to detect collisions. Once two balls collide,
 *  remove the later ball that was added to the pane and add its radius
 *  to the other ball, as shown in Figure 20.17b. Use the Suspend button
 *  to suspend the animation and the Resume button to resume the animation.
 *  Add a mouse pressed handler that removes a ball when the mouse
 *  is pressed on the ball.
 *
 * Created by Luiz Arantes Sa on 12/18/14.
 */
public class Exercise_05 extends MultipleBounceBall {

    @Override
    public void start(Stage primaryStage) {
        MultipleBallPane ballPane = new MultipleBallPane();
        ballPane.setStyle("-fx-border-color: yellow");

        Button btAdd = new Button("+");
        Button btSubtract = new Button("-");
        Button btSuspend = new Button("Suspend");
        Button btResume = new Button("Resume");

        HBox hBox = new HBox(10, btSuspend, btResume, btAdd, btSubtract);
        hBox.setPadding(new Insets(5));
        hBox.setAlignment(Pos.CENTER);

        // Add or remove a ball
        btAdd.setOnAction(e -> ballPane.add());
        btSubtract.setOnAction(e -> ballPane.subtract());

        // Pause and resume animation
        btSuspend.setOnAction(e -> ballPane.pause());
        btResume.setOnAction(e -> ballPane.play());

        // Use a scroll bar to control animation speed
        ScrollBar sbSpeed = new ScrollBar();
        sbSpeed.setMax(50);
        sbSpeed.setValue(10);
        ballPane.rateProperty().bind(sbSpeed.valueProperty());

        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setTop(sbSpeed);
        pane.setBottom(hBox);

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("MultipleBounceBall"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
