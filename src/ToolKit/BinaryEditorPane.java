package ToolKit;

import javafx.scene.input.KeyCode;

import java.io.*;

/**
 * Binary Editor
 * <p>
 * Let's you view and edit any file in binary format
 * <p>
 * Created by Luiz Arantes Sa on 11/30/14.
 */
public class BinaryEditorPane extends FileViewerPane {

    protected File file;

    public BinaryEditorPane() {

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
                s += getBits(r);

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

    private String getBits(int value) {

        String byteString = "";

        for (int i = 7; i >= 0; i--)
            byteString += ((value >> i) & 1);

        return byteString;
    }
}
