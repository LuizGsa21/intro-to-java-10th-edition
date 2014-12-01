package Chapter_17;

import ToolKit.HexEditorPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * (Hex editor)
 * Write a GUI application that lets the user enter a file name
 * in the text field and press the Enter key to display its hex
 * representation in a text area. The user can also modify the
 * hex code and save it back to the file.
 * Created by Luiz Arantes Sa on 11/30/14.
 */
public class Exercise_21 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HexEditorPane pane = new HexEditorPane();
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

}
