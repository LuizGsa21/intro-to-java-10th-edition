package ToolKit;

import javafx.geometry.VPos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by luizsa on 9/25/14.
 */
public class Histogram extends Pane {

    private char[] chars = new char[26];
    private int counts[] = new int[26];
    private Rectangle[] bars = new Rectangle[26];
    private File file;
    GridPane pane;

    double w = 350;
    double h = 350;

    public Histogram(String filename) {

        this.file = new File(filename.trim());

        setWidth(w);
        setHeight(h);
        readFile();
        draw();
    }

    private void readFile() {

        Scanner scanner;
        String s = "";
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {

                s += scanner.nextLine();
            }
        } catch (IOException ex) {
        }

        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (Character.isLetter(character)) {
                counts[character - 'A']++;
            }
        }

    }
    private double getTotal() {
        double total = 0;
        for (int count : counts) {
            total += count;
        }
        return total;
    }

    private void draw() {

        pane = new GridPane();
        double barW = w / chars.length;
        double total = getTotal();

        for (int i = 0; i < counts.length; i++) {
            chars[i] = (char) ('A' + i);

            double percentage = counts[i] / total;
            double barH = h * percentage;

            bars[i] = new Rectangle(barW, barH);
            Label label = new Label(chars[i] + "", bars[i]);
            label.setContentDisplay(ContentDisplay.TOP);

            pane.add(label, i, 0);
            GridPane.setValignment(label, VPos.BASELINE);

        }
        getChildren().addAll(pane);

    }

    public int[] getCounts() {
        return counts;
    }

    public void setCounts(int[] counts) {
        this.counts = counts;
        draw();
    }

}
