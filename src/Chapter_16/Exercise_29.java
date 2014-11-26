package Chapter_16;

import ToolKit.MyCalendar;
import ToolKit.MyCalendarGUI;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Calendar;

/**
 * (Display a calendar)
 * Write a program that displays the calendar for the current month.
 * You can use the Prior and Next buttons to show the calendar of
 * the previous or next month. Display the dates in the current
 * month in black and display the dates in the previous month and
 * next month in gray, as shown in Figure 16.48.
 * <p>
 * Created by luizsa on 9/30/14.
 */
public class Exercise_29 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        CalendarPane pane = new CalendarPane(9, 2014);

        BorderPane borderPane = new BorderPane(pane);

        Button btPrevious = new Button("Previous");
        btPrevious.setOnAction(e -> pane.previousMonth());

        Button btNext = new Button("Next");
        btNext.setOnAction(e -> pane.nextMonth());

        HBox bottomPane = new HBox(btPrevious, btNext);
        bottomPane.setSpacing(10);
        bottomPane.setPadding(new Insets(5));
        bottomPane.setAlignment(Pos.CENTER);

        borderPane.setBottom(bottomPane);

        Scene scene = new Scene(borderPane, pane.getPrefWidth(), 225);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calendar");
        primaryStage.show();
    }

    private class CalendarPane extends GridPane {

        MyCalendarGUI cal;
        Label lblMonthYear;

        Label[] lblDayOfWeek = new Label[7];

        private CalendarPane(int month, int year) {

            cal = new MyCalendarGUI(year, --month, 1);

            for (int i = 0; i < lblDayOfWeek.length; i++) {
                lblDayOfWeek[i] = new Label(MyCalendarGUI.getDayOfWeekName(i));
                add(lblDayOfWeek[i], i, 1);
            }

            // set gaps
            setHgap(10);
            setVgap(5);

            setPadding(new Insets(5));
            draw();
        }

        private void draw() {

            getChildren().clear();

            // Title
            lblMonthYear = new Label(cal.getMonthName() + ", " + cal.get(Calendar.YEAR));
            HBox monthYearPane = new HBox(lblMonthYear);
            monthYearPane.setAlignment(Pos.CENTER);
            add(monthYearPane, 0, 0, 7, 1);

            // Days of week name
            for (int i = 0; i < lblDayOfWeek.length; i++) {
                add(lblDayOfWeek[i], i, 1);
            }

            // start day
            int startDay = cal.getStartDay();

            int row = 2;

            // add days prior to current month
            if (startDay > 0) {

                int days = MyCalendar.daysInMonth(
                        cal.get(Calendar.MONTH) - 1, cal.get(Calendar.YEAR));
                days -= startDay -1;

                for (int i = 0; i < startDay; i++) {
                    Label lblDay = new Label(days++ + "");
                    lblDay.setTextFill(Color.grayRgb(10, 0.5));

                    HBox dayHbox = new HBox(lblDay);
                    dayHbox.setAlignment(Pos.CENTER_LEFT);
                    add(dayHbox, i % 7, row);
                }

            }

            // add current days of month
            for (int day = 1; day <= cal.daysInMonth(); day++) {

                Label lblDay = new Label(day + "");
                HBox dayHbox = new HBox(lblDay);
                dayHbox.setAlignment(Pos.CENTER_LEFT);


                add(dayHbox, startDay % 7, row);

                startDay++;
                if (startDay % 7 == 0) {
                    row++;
                }
            }

            // add next month's days
            int day = 1;
            while (startDay % 7 != 0) {
                Label lblDay = new Label(day++ + "");
                HBox dayHbox = new HBox(lblDay);
                dayHbox.setAlignment(Pos.CENTER_LEFT);
                add(dayHbox, startDay % 7, row);
                lblDay.setTextFill(Color.grayRgb(10, 0.5));

                startDay++;
            }

        }

        public void nextMonth() {
            cal.nextMonth();
            draw();
        }

        public void previousMonth() {
            cal.previousMonth();
            draw();
        }
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
