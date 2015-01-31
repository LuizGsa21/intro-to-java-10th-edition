package Chapter_19;

import java.util.Arrays;

/**
 * (Revising Listing 19.1)
 * Revise the GenericStack class in Listing 19.1 to implement it using an array
 * rather than an ArrayList. You should check the array size before adding a new
 * element to the stack. If the array is full, create a new array that doubles the
 * current array size and copy the elements from the current array to the new array.
 *
 * Created by Luiz Arantes Sa on 12/17/14.
 */
public class Exercise_01 {

    public static void main(String[] args) {

        GenericStack<Integer> numberStack = new GenericStack<>();

        for (int i = 0; i < 10000; i++) {
            numberStack.push(i);
        }

        System.out.println("Current Size" + numberStack.getSize());
        System.out.println("Is stack empty? " + numberStack.isEmpty());
        System.out.println("Pop: " + numberStack.pop());
        System.out.println("Pop: " + numberStack.pop());
        System.out.println("Current Size " + numberStack.getSize());
        System.out.println("Popping all from stack...");

    }

    static private class GenericStack<E> {

        private int capacity = 100;
        private int size;
        private E[] array = (E[])new Object[capacity];

        GenericStack() {

        }

        public int getSize() {
            return size;
        }

        public E peek() {
            if (size == 0)
                return null;
            else
                return array[size - 1];
        }

        public void push(E o) {
            array[size++] = o;
            if (size == capacity) {
                E[] tmp = (E[])new Object[capacity *= 2];
                System.arraycopy(array, 0, tmp, 0, array.length);
                array = tmp;
            }
        }

        public E pop() {
            if (size == 0)
                return null;
            else
                return array[--size];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public String toString() {
            return "stack: " + Arrays.toString(array);
        }
    }
}
