package Chapter_17;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.*;

/**
 * (Split files GUI)
 *
 * Rewrite Exercise 17.10 with a GUI, as shown in Figure 17.21a.
 *
 * Created by Luiz Arantes Sa on 11/29/14.
 */
public class Exercise_11  extends Application {

    @Override
    public void start(Stage primaryStage) {

        FileSplitterPane pane = new FileSplitterPane();

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("File Splitter");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private class FileSplitterPane extends BorderPane {

        TextField tfFilename;
        TextField tfNumOfDivision;
        Button btnSplit;

        FileSplitterPane() {

            tfFilename = new TextField();
            tfNumOfDivision = new TextField();

            btnSplit = new Button("Split File");
            btnSplit.setOnAction(e -> splitFile());

            Label lblDescription = new Label(
                    "If you split a file named temp.txt into 3 smaller files,\n" +
                    "the 3 smaller files are temp.txt.1, temp.txt.2, temp.txt.3 \n" +
                            "Enter absolute path if file is not in working directory...");
            Label lblFilename = new Label("Filename:");
            Label lblNumOfDivision = new Label("Split number:");

            // Format gridPane and nodes
            GridPane gridPane = new GridPane();
            gridPane.add(lblDescription, 0, 0,2,1);
            gridPane.addRow(1, lblFilename, tfFilename);
            gridPane.addRow(2, lblNumOfDivision, tfNumOfDivision);
            gridPane.setHgap(10);
            gridPane.setVgap(10);
            gridPane.setPadding(new Insets(20));
            GridPane.setFillWidth(tfNumOfDivision, false);
            tfNumOfDivision.setPrefColumnCount(4);

            setCenter(gridPane);
            setBottom(btnSplit);

            setAlignment(btnSplit, Pos.CENTER);
            setPadding(new Insets(10));
        }

        private void splitFile() {

            File file = new File(tfFilename.getText());

            int divisions = Integer.parseInt(tfNumOfDivision.getText());

            long limit = file.length() / divisions + 1;

            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {

                for (int i = 1; i <= divisions; i++) {
                    int current = 0;
                    try (BufferedOutputStream out =
                                 new BufferedOutputStream(new FileOutputStream(new File(file.getAbsoluteFile() + "." + i)))) {
                        int buffer;
                        while (current++ < limit && (buffer = in.read()) != -1) {
                            out.write(buffer);
                        }
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
