package Chapter_05;

/**
 * Chapter 5 Exercise 18:
 *
 *      (Display four patterns using loops)
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_18 {

    public static void main(String[] strings) {

        System.out.println("\n\nPattern A");
        for (int i = 1; i <= 6; i++)    {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("\n\nPattern B");
        for (int i = 1; i <= 6; i++)    {
            for (int j = 1; j <=  7 - i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("\n\nPattern C");
        for (int i = 1; i <= 6; i++)    {
            for (int k = 1; k <= 6 - i; k++){
                System.out.print("  ");
            }
            for (int j = 1; j <=  i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("\n\nPattern D");
        for (int i = 1; i <= 6; i++)    {
            for (int k = i; k > 1; k--){
                System.out.print("  ");
            }
            for (int j = 1; j <=  7 - i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
