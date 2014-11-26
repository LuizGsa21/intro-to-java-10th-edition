package Chapter_02;

import java.util.Scanner;

/**
 * Chapter 2 Exercise 11:
 *
 *      (Population projection)
 * Created by Luiz Arantes Sa on 6/20/14.
 */
public class Exersice_11 {

    public static void main(String[] strings) {

        double birthRateInSeconds = 7.0;
        double deathRateInSeconds = 13.0;
        double newImmigrantInSeconds = 45.0;


        double currentPopulation = 312032487.0;

        double secondsInYears = 60.0 * 60.0 * 24.0 * 365.0;

        double numBirths = secondsInYears / birthRateInSeconds;
        double numDeaths = secondsInYears / deathRateInSeconds;
        double numImmigrants = secondsInYears / newImmigrantInSeconds;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of years: ");
        int numberOfYears = input.nextInt();

        for (int i = 0; i < numberOfYears; i++) {

            currentPopulation += numBirths + numImmigrants - numDeaths;

        }

        System.out.println("The population in " + numberOfYears + " is " + (long) currentPopulation);

    }

}
