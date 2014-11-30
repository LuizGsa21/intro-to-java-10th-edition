package Chapter_17;

import ToolKit.Contact;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;


/**
 * (Address book)
 * Write a program that stores, retrieves, adds, and
 * updates addresses as shown in Figure 17.20. Use a
 * fixed-length string for storing each attribute in the address.
 * Use random access file for reading and writing an address. Assume
 * that the size of name, street, city, state, and zip is 32,
 * 32, 20, 2, 5 bytes, respectively. [91]
 * <p>
 * Created by Luiz Arantes Sa on 10/5/14.
 */
public class Exercise_09 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        AddressBook addrPane = new AddressBook("/Users/Kernel/Desktop/");
        primaryStage.setScene(new Scene(addrPane));
        primaryStage.setTitle("Address Book");
        primaryStage.show();

    }

}

class BasicAddressPane extends GridPane {

    // Labels
    Label lblName;
    Label lblStreet;
    Label lblCity;
    Label lblState;
    Label lblZip;


    // TextFields
    TextField tfName;
    TextField tfStreet;
    TextField tfCity;
    TextField tfState;
    TextField tfZip;

    BasicAddressPane() {

        // Grid pane settings
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(10);

        // Create Labels with Textfield
        lblName = createComponent("Name:", 0, tfName = new TextField(), 0);
        lblStreet = createComponent("Street:", 0, tfStreet = new TextField(), 0);
        lblCity = createComponent("City:", 140, tfCity = new TextField(), 100);
        lblState = createComponent("State:", 90, tfState = new TextField(), 40);
        lblZip = createComponent("Zip:", 130, tfZip = new TextField(), 100);

        // add name on first row
        this.add(lblName, 0, 0, 5, 1);
        tfName.setPrefColumnCount(25);

        // add street on second row
        this.add(lblStreet, 0, 1, 5, 1);
        tfStreet.setPrefColumnCount(25);

        // add city, state, zip on third row
        HBox hBox = new HBox();
        hBox.getChildren().addAll(lblCity, lblState, lblZip);
        hBox.setMaxWidth(410);
        hBox.setSpacing(5);
        this.add(hBox, 0, 2, 5, 1);

    }

    /**
     * @param name      - Name of Label
     * @param lblWidth  - Label max width: 0 = default
     * @param textField - TextField to be attached with label
     * @param tfWidth   - TextField max width: 0 = default
     * @return Label
     */
    private Label createComponent(String name, double lblWidth, TextField textField, double tfWidth) {
        Label label = new Label(name, textField);
        label.setContentDisplay(ContentDisplay.RIGHT);

        // set textfield and label custom min width if needed
        if (lblWidth > 0) {
            label.setMaxWidth(lblWidth);
        }
        if (tfWidth > 0) {
            textField.setMaxWidth(tfWidth);
        }
        return label;
    }

    protected void setTextFields(String name, String street, String city, String state, String zip) {
        tfName.setText(name);
        tfStreet.setText(street);
        tfCity.setText(city);
        tfState.setText(state);
        tfZip.setText(zip);
    }

}

class AddressBook extends BasicAddressPane {


    ArrayList<Contact> contacts;
    int index = 0;

    // Buttons
    Button btnAdd;
    Button btnFirst;
    Button btnNext;
    Button btnPrev;
    Button btnLast;
    Button btnUpdate;

    boolean isNewFile;

    String fileName = "AddressBook.dat";


    File file;

    AddressBook() {
        this(System.getProperty("user.dir")); // default path is current working directory
    }

    AddressBook(String path) {

        btnAdd = new Button("Add");
        btnFirst = new Button("First");
        btnNext = new Button("Next");
        btnPrev = new Button("Prev");
        btnLast = new Button("Last");
        btnUpdate = new Button("Update");

        // Init buttons and create bottom button panel
        HBox hBox = new HBox(15, btnAdd, btnFirst, btnPrev, btnNext, btnLast, btnUpdate);
        hBox.setAlignment(Pos.CENTER);
        this.add(hBox, 0, 3, 5, 1);

        // create listeners
        btnAdd.setOnAction(e -> addContact());
        btnUpdate.setOnAction(e -> updateContact());

        btnFirst.setOnAction(e -> {
            index = 0;
            refresh();
        });
        btnLast.setOnAction(e -> {
            index = contacts.size() - 1;
            refresh();
        });

        btnNext.setOnAction(e -> next());
        btnPrev.setOnAction(e -> previous());

        // Get address book file
        file = new File(path + fileName);
        // if file doesn't exist, create it
        try {
            isNewFile = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!isNewFile) {
            syncContacts();
        } else {
            contacts = new ArrayList<>();

        }

        refresh();
    }

    private void previous() {
        if (index > 0) {
            index--;
            refresh();
        }
    }

    private void next() {
        if (index != contacts.size() - 1) {
            index++;
            refresh();
        }
    }

    private void refresh() {

        if (contacts.isEmpty()) return;

        Contact c = contacts.get(index);
        setTextFields(
                c.getFullName(),
                c.getStreet(),
                c.getCity(),
                c.getState(),
                c.getZip()
        );

    }

    public void addContact() {
        contacts.add(getCurrentContact());
        index = contacts.size() - 1;
        refresh();
        saveContacts();
    }

    public void updateContact() {
        contacts.remove(index);
        contacts.add(index, getCurrentContact());
        saveContacts();
    }

    public Contact getCurrentContact() {
        return new Contact(
                tfName.getText(),
                tfStreet.getText(),
                tfCity.getText(),
                tfState.getText(),
                tfZip.getText()
        );
    }

    /**
     * Reads address book and saves contacts to ArrayList
     */
    private void syncContacts() {

        // Init new buffer array
        contacts = new ArrayList<>();

        // Byte array for each field
        byte[] name = new byte[32];
        byte[] street = new byte[32];
        byte[] city = new byte[20];
        byte[] state = new byte[2];
        byte[] zip = new byte[5];

        try (FileInputStream input = new FileInputStream(file)) {

            while (input.available() >= 91 && -1 != input.read(name)) {

                input.read(street);
                input.read(city);
                input.read(state);
                input.read(zip);
                contacts.add(new Contact(
                        new String(name, "UTF-8"),
                        new String(street, "UTF-8"),
                        new String(city, "UTF-8"),
                        new String(state, "UTF-8"),
                        new String(zip, "UTF-8")
                ));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void saveContacts() {

        try (FileOutputStream out = new FileOutputStream(file)) {

            for (Contact c : contacts) {
                out.write(getFixedSizeByteArray(c.getFullName(), 32));
                out.write(getFixedSizeByteArray(c.getStreet(), 32));
                out.write(getFixedSizeByteArray(c.getCity(), 20));
                out.write(getFixedSizeByteArray(c.getState(), 2));
                out.write(getFixedSizeByteArray(c.getZip(), 5));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private byte[] getFixedSizeByteArray(String string, int fixedSize) {

        byte[] src = string.getBytes();
        byte[] fixedArray = new byte[fixedSize];
        System.arraycopy(src, 0, fixedArray, 0, Math.min(src.length, fixedSize));

        return fixedArray;
    }


}
