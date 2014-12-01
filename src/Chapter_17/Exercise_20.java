package Chapter_17;

import ToolKit.BinaryEditorPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * (Binary editor)
 * <p>Write a GUI application that lets the user enter a file name in the text
 * field and press the Enter key to display its binary representation in a text area.
 * The user can also modify the binary code and save it back to the file</p>
 * <p>
 * Created by Luiz Arantes Sa on 11/30/14.
 */
public class Exercise_20 extends Application {

    public static void main(String[] args) {

        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) {


        BinaryEditorPane pane = new BinaryEditorPane();
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();

    }


}
