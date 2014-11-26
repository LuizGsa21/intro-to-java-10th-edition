package Chapter_08;

/**
 * Chapter 8 Exercise 3:
 *
 *      (Sort students on grades)
 *      Rewrite Listing 8.2, GradeExam.java, to display the students in increasing
 *      order of the number of correct answers.
 *
 * Created by Luiz Arantes Sa on 8/29/14.
 */
public class Exercise_03 {
    /** Main method */
    static final int STUDENT = 0;
    static final int GRADE = 1;
    public static void main(String args[]) {
        // Students' answers to the questions
        char[][] answers = {
                {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
                {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
                {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
                {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};

        // Key to the questions
        char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};
        int[][] studentGrades = new int[answers.length][2];

        // Grade all answers
        for (int i = 0; i < answers.length; i++) {

            // Grade one student
            int correctCount = 0;
            for (int j = 0; j < answers[i].length; j++) {
                if (answers[i][j] == keys[j])
                    correctCount++;

            }
            studentGrades[i][STUDENT] = i;
            studentGrades[i][GRADE] = correctCount;
        }

        sort(studentGrades);

        for (int i = 0; i < studentGrades.length; i++ ) {
            System.out.println("Student " + studentGrades[i][STUDENT] + "'s correct count is " +
                    studentGrades[i][GRADE]);
        }
    }

    public static void sort(int[][] m) {

        for (int i = 0; i < m.length - 1; i++) {
            int currentIndex = i;
            int currentMin = m[i][GRADE];
            int studentNum = m[i][STUDENT];

            for (int j = i + 1; j < m.length; j++) {
                if (currentMin > m[j][GRADE]) {
                    currentMin = m[j][GRADE];
                    studentNum = m[j][STUDENT];
                    currentIndex = j;
                }
            }

            if (currentIndex != i) {
                m[currentIndex][GRADE] = m[i][GRADE];
                m[currentIndex][STUDENT] = m[i][STUDENT];
                m[i][GRADE] = currentMin;
                m[i][STUDENT] = studentNum;
            }
        }
    }
}
