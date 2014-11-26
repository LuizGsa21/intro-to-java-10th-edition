package Chapter_14;

import ToolKit.BeanMachinePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Chapter 14 Exercise 29:
 *
 *      (Game: bean machine)
 *      Write a program that displays a bean machine introduced
 *      in Programming Exercise 7.21, as shown in Figure 14.52c.
 *
 * Created by Luiz Arantes Sa on 9/14/14.
 */
public class Exercise_29 extends Application {

    @Override
    public void start(Stage primaryStage) {

        BeanMachinePane pane = new BeanMachinePane();

        System.out.println(pane.getWidth());
        Scene scene = new Scene(pane, pane.getW(), pane.getH());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bean Machine");
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);

    }
}
