package Chapter_16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * (Demonstrate Label properties)
 * Write a program to let the user dynamically set the properties
 * contentDisplay and graphicTextGap, as shown in Figure 16.42b.
 *
 * Created by luizsa on 9/27/14.
 */
public class Exercise_15 extends Application {

    Label lblGrapes = new Label("Grapes", new ImageView("/image/grapes.gif"));

    @Override
    public void start(Stage primaryStage) throws Exception {

        lblGrapes.setPadding(new Insets(5));
        ComboBox<String> cbContentDis = new ComboBox<>();
        String[] options = {"TOP", "BOTTOM", "LEFT", "RIGHT"};
        cbContentDis.getItems().addAll(options);
        cbContentDis.setValue(options[2]);
        cbContentDis.setOnAction(e-> {
            update(cbContentDis.getValue());
            primaryStage.sizeToScene();
        });
        Label lblContentDis = new Label("Content Display:", cbContentDis);
        lblContentDis.setContentDisplay(ContentDisplay.RIGHT);

        TextField tfGTxtGap = new TextField();
        tfGTxtGap.setPrefColumnCount(4);
        tfGTxtGap.setText(lblGrapes.getGraphicTextGap() + "");
        tfGTxtGap.setOnAction(e-> {
            lblGrapes.setGraphicTextGap(
                    Double.parseDouble(tfGTxtGap.getText()));
            primaryStage.sizeToScene();
        });

        Label lblGTxtGap = new Label("Graphic Text Gap:", tfGTxtGap);
        lblGTxtGap.setContentDisplay(ContentDisplay.RIGHT);
        HBox topPane = new HBox(lblContentDis, lblGTxtGap);
        topPane.setSpacing(5);
        topPane.setPadding(new Insets(5));

        StackPane pane = new StackPane(lblGrapes);

        BorderPane borderPane = new BorderPane(pane);
        borderPane.setTop(topPane);
        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("Graphic content display");
        primaryStage.show();
    }

    public void update(String direction) {
        switch (direction) {
            case "TOP": lblGrapes.setContentDisplay(ContentDisplay.TOP);break;
            case "BOTTOM": lblGrapes.setContentDisplay(ContentDisplay.BOTTOM);break;
            case "RIGHT": lblGrapes.setContentDisplay(ContentDisplay.RIGHT);break;
            case "LEFT": lblGrapes.setContentDisplay(ContentDisplay.LEFT);break;
        }
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
