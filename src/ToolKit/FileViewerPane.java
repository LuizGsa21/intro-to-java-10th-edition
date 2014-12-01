package ToolKit;

import javafx.beans.property.Property;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * Basic File viewer pane template
 * Created by Luiz Arantes Sa on 11/30/14.
 */
public class FileViewerPane extends BorderPane {

    protected Label lblFilePath = new Label("Enter a file:");
    protected TextField tfFilePath = new TextField();

    protected TextArea taContent = new TextArea();

    protected Button btnSave = new Button("Save Changes");

    public FileViewerPane() {

        // Top border pane custom settings
        HBox topPane = new HBox(10,lblFilePath, tfFilePath);
        topPane.setPadding(new Insets(10));
        topPane.setAlignment(Pos.BASELINE_LEFT);

        // Bottom border pane custom settings
        HBox bottomPane = new HBox(btnSave);
        bottomPane.setAlignment(Pos.BASELINE_CENTER);
        bottomPane.setPadding(new Insets(10));

        // Member nodes custom settings
        tfFilePath.setPrefColumnCount(32);
        taContent.setWrapText(true);

        // Adding panes to borderPane
        setTop(topPane);
        setCenter(new ScrollPane(taContent));
        setBottom(bottomPane);

    }


}
