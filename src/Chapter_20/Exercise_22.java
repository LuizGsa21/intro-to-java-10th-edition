package Chapter_20;

import java.util.*;

/**
 * (Non-recursive Tower of Hanoi)
 * Implement the moveDisks method in Listing 18.8 using a stack instead of using recursion.
 * Created by Luiz Arantes Sa on 1/24/15.
 */
public class Exercise_22 {

    private static final int NUM_OF_DISKS = 3;

    private static ArrayList<Stack<Integer>> stacks = new ArrayList<>(3);

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++)
            stacks.add(new Stack<>());

        Stack center = stacks.get(1); // center pillar

        for (int i = NUM_OF_DISKS; i > 0; i--) // push 3 disks
            stacks.get(0).push(i);


        boolean isSmallestMove = true;
        while (center.size() != NUM_OF_DISKS) {
            if (isSmallestMove)
                moveSmallest();
             else
                makeLegalMove();
            isSmallestMove = !isSmallestMove;
            displayStacks();
        }
    }

    public static void makeLegalMove() {

        ArrayList<Stack<Integer>> excludeSmallest = new ArrayList<>(stacks);
        excludeSmallest.remove(getSmallest());

        Stack<Integer> stk1 = excludeSmallest.get(0);
        Stack<Integer> stk2 = excludeSmallest.get(1);

        if (stk1.empty() && stk2.isEmpty()) return;
        if (stk1.empty())
            stk1.push(stk2.pop());
        else if (stk2.isEmpty())
            stk2.push(stk1.pop());
        else if (stk1.peek() < stk2.peek())
            stk2.push(stk1.pop());
        else
            stk1.push(stk2.pop());
    }

    public static void moveSmallest() {
        Stack<Integer> smallest = getSmallest();

        int size = stacks.size();
        int index = stacks.indexOf(smallest);
        int delta = ((size & 1) == 1) ? 1 : -1;
        index += delta;

        if (index < 0)
            index = size - 1;
        if (index == size)
            index = 0;

        // Move smallest
        stacks.get(index).push(smallest.pop());
    }

    public static Stack<Integer> getSmallest() {
        Stack<Integer> smallest = null;
        for (Stack<Integer> stack : stacks) {
            if (smallest == null) smallest = stack;
            if (stack.isEmpty()) continue;
            try {
                if (smallest.isEmpty())
                    smallest = stack;
                else if (stack.peek() < smallest.peek())
                    smallest = stack;
            } catch (EmptyStackException ignore) {
            }
        }
        return smallest;
    }


    public static void displayStacks() {
        System.out.println("Stacks:");
        for (Stack stack : stacks) {
            System.out.println(stack);
        }
        System.out.println("");
    }
}
