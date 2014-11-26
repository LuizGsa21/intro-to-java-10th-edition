package Chapter_16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by luizsa on 9/25/14.
 */
public class Exercise_10 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        TextEditor textEditor = new TextEditor();
        primaryStage.setScene(new Scene(textEditor));
        primaryStage.show();
    }

    private class TextEditor extends VBox {
        TextArea ta;
        TextField tfPath;

        private TextEditor() {
            ta = new TextArea();
            ta.setPrefSize(350, 150);

            // Bottom pane: contains tf and bt to retrieve file path and open file
            tfPath = new TextField();
            tfPath.setOnAction(e-> readFile());
            Label lblPath = new Label("Filename", tfPath);
            lblPath.setContentDisplay(ContentDisplay.RIGHT);
            Button btView = new Button("View");
            btView.setOnAction(e->{
                readFile();
            });

            tfPath.setPrefColumnCount(ta.getPrefColumnCount() - 9);

            HBox filePath = new HBox(lblPath, btView);

            getChildren().addAll(ta, filePath);
            autosize();
        }

        private void readFile() {

            File file = new File(tfPath.getText());

            if (!file.exists()) {
                ta.setText("FILE NOT FOUND");
                return;
            }


            Scanner scanner;
            StringBuilder sb = new StringBuilder();
            try {
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    sb.append(scanner.nextLine() + "\n");
                }
                ta.setText(sb.toString());
            } catch (IOException ex) {
                ta.setText("Error opening file...");
            }


        }
    }




    public static void main(String[] args) {
        Application.launch(args);
    }
}
