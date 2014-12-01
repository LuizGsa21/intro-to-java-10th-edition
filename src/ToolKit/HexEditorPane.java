package ToolKit;

import javafx.scene.input.KeyCode;

import java.io.*;

/**
 * Hex Editor
 * <p>
 * Let's you view and edit any file in hexadecimal format
 * <p>
 * Created by Luiz Arantes Sa on 11/30/14.
 */
public class HexEditorPane extends FileViewerPane {

    protected File file;

    public HexEditorPane() {

        tfFilePath.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER)
                loadFile();
        });
        btnSave.setOnAction(e -> save());

    }

    private void loadFile() {
        file = new File(tfFilePath.getText());

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file), 25000)) {

            String s = "";
            int r;
            while ((r = in.read()) != -1)
                s += Integer.toHexString(r);

            taContent.setText(s);
        } catch (FileNotFoundException ex) {
            System.out.println("Error: File not found! Try using an absolute path.");
        } catch (IOException ex) {
            System.out.println("Error reading file...");
        }
    }

    private void save() {

        try (BitOutputStream out = new BitOutputStream(file)) {

            out.writeBit(taContent.getText());

        } catch (IOException ex) {
            System.out.println("Error saving file..");
        }
    }
}
