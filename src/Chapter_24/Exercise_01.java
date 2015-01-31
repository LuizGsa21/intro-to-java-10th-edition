package Chapter_24;

/**
 * (Add set operations in MyList)
 * Define the following methods in MyList and implement them in MyAbstractList:
 * public boolean addAll(MyList<E> otherList);
 * public boolean removeAll(MyList<E> otherList);
 * public boolean retainAll(MyList<E> otherList);
 * <p>
 * Write a test program that creates two MyArrayLists, list1 and list2,
 * with the initial values {"Tom", "George", "Peter", "Jean", "Jane"} and
 * {"Tom", "George", "Michael", "Michelle", "Daniel"},
 * then perform the following operations:
 * <p>
 * ■ Invokes list1.addAll(list2), and displays list1 and list2.
 * ■ Recreates list1 and list2 with the same initial values, invokes
 * list1.removeAll(list2), and displays list1 and list2.
 * ■ Recreates list1 and list2 with the same initial values, invokes
 * list1.retainAll(list2), and displays list1 and list2.
 * <p>
 * Created by Luiz Arantes Sa on 1/30/15.
 */
public class Exercise_01 {

    public static void main(String[] args) throws Throwable {

        String[] array1 = {"Tom", "George", "Peter", "Jean", "Jane"};
        String[] array2 = {"Tom", "George", "Michael", "Michelle", "Daniel"};

        MyArrayList<String> list1 = new MyArrayList(array1);
        MyArrayList<String> list2 = new MyArrayList(array2);

        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println("Test below...\n");

        list1.addAll(list2);
        System.out.println("addAll\nlist1 = " + list1);
        System.out.println("list2 = " + list2 + "\n");

        list1 = new MyArrayList(array1);
        list2 = new MyArrayList(array2);

        list1.removeAll(list2);
        System.out.println("removeAll\nlist1 = " + list1);
        System.out.println("list2 = " + list2 + "\n");

        list1 = new MyArrayList(array1);
        list2 = new MyArrayList(array2);

        list1.retainAll(list2);
        System.out.println("retainAll\nlist1 = " + list1);
        System.out.println("list2 = " + list2 + "\n");
        System.out.println();

    }
}