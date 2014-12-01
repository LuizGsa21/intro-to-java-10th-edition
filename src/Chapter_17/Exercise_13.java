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
import javafx.stage.Stage;
import java.io.*;

/**
 * (Combine files GUI)
 *  Rewrite Exercise 17.12 with a GUI, as shown in Figure 17.21b.
 *  Created by Luiz Arantes Sa on 11/30/14.
 */
public class Exercise_13  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FileCombinerPane pane = new FileCombinerPane();

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("File Combiner");
        primaryStage.show();

    }

    private class FileCombinerPane extends BorderPane {

        TextField tfFilename;
        TextField tfNumOfDivision;
        Button btnSplit;

        FileCombinerPane() {

            tfFilename = new TextField();
            tfNumOfDivision = new TextField();

            btnSplit = new Button("Combine Files");
            btnSplit.setOnAction(e -> combineFiles());

            Label lblDescription = new Label(
                    "If the base file is named temp.txt with 3 peices,\n" +
                            "temp.txt.1, temp.txt.2, temp.txt.3 are combined into temp.txt\n" +
                            "Enter absolute path if file is not in working directory...");
            Label lblFilename = new Label("Base Filename:");
            Label lblNumOfDivision = new Label("Number Of Files:");

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

        public void combineFiles() {

            File[] splitFiles = new File[Integer.parseInt(tfNumOfDivision.getText())];
            File targetFile = new File(tfFilename.getText());

            // Verify if src files exists
            for (int i = 0; i < splitFiles.length; i++) {
                splitFiles[i] = new File(targetFile.getAbsolutePath() + "." + (i + 1) );
                if (!splitFiles[i].isFile()) {
                    System.out.println(splitFiles[i].getAbsolutePath() + " file not found.");
                }
            }


            // Combine files into targetFile
            try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(targetFile))) {

                int buffer;
                for (File f : splitFiles) {
                    try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(f))) {

                        while ((buffer = in.read()) != -1)
                            out.write(buffer);

                    }
                }
            } catch (IOException ex) {
                System.out.println("Error combining files");
            }
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
