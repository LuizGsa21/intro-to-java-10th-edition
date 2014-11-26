package Chapter_10;

import ToolKit.BMI;

/**
 * Chapter 10 Exercise 2:
 *
 *      (The BMI class) Add the following new constructor in the BMI class:
 *
 *      public BMI(String name, int age, double weight, double feet, double inches)
 *
 *
 */
public class Exercise_02 {

    public static void main(String[] args) {

        BMI p = new BMI("Luiz", 22, 175, 5, 7);
        System.out.printf("Name: %s Age: %d weight: %.2f feet: %.2f inches: %.2f\n",
                p.getName(), p.getAge(), p.getWeight(), p.getFeet(), p.getInches());
    }


}
