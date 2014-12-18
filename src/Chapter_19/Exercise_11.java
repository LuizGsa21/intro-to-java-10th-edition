package Chapter_19;

import ToolKit.Complex;
import ToolKit.GenericMatrix;

/**
 * (ComplexMatrix)
 * Use the Complex class introduced in Programming Exercise 13.17
 * to develop the ComplexMatrix class for performing matrix operations
 * involving complex numbers. The ComplexMatrix class should extend the
 * GenericMatrix class and implement the add, multiple, and zero methods.
 * You need to modify GenericMatrix and replace every occurrence of Number by Object,
 * because Complex is not a subtype of Number. Write a test program that creates the
 * following two matrices and displays the result of addition and multiplication
 * of the matrices by invoking the printResult method.
 *
 * Created by Luiz Arantes Sa on 12/18/14.
 */
public class Exercise_11 {


    public static void main(String[] args) {

        Complex[][] m1 = createMatrix(3);
        Complex[][] m2 = createMatrix(3);


        ComplexMatrix matrix = new ComplexMatrix();
        ComplexMatrix.printResult(m1, m2, matrix.addMatrix(m1, m2), '+');

    }

    public static Complex[][] createMatrix(int size) {
        Complex[][] m1 = new Complex[size][size];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {

                m1[i][j] = new Complex(Math.random() * 10, Math.random() * 10);
            }
        }

        return m1;
    }

}

class ComplexMatrix extends GenericMatrix<Complex> {

    @Override
    protected Complex add(Complex o1, Complex o2) {
        return o1.add(o2);
    }

    @Override
    protected Complex multiply(Complex o1, Complex o2) {
        return o1.multiply(o2);
    }

    @Override
    protected Complex zero() {
        return new Complex(0);
    }

}