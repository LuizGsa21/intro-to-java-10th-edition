package Chapter_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Chapter 12 Exercise 20:
 *
 *      (Remove package statement)
 *      Suppose you have Java source files under the directories
 *      chapter1, chapter2, . . . , chapter34. Write a program to remove the
 *      statement package chapteri; in the first line for each Java source file
 *      under the directory chapteri. Suppose chapter1, chapter2, . . . ,
 *      chapter34 are under the root directory srcRootDirectory. The root
 *      directory and chapteri directory may contain other folders and files.
 *      Use the following command to run the program:
 *
 *      java Exercise12_20 srcRootDirectory
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_20 {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Invalid arguments.");
            System.out.println("Usage: java Chapter_12.Exercise_20 srcRootDirectory");
            System.exit(1);
        }
        File rootDir = new File(args[0]);
        if (!rootDir.isDirectory()) {
            System.out.println(rootDir.getAbsolutePath());
            System.out.println(rootDir + " is not a directory.");
        }
        File[] rootDirFiles = rootDir.listFiles();
        rootDirFiles = getSpecifiedDirs(rootDirFiles, "Chapter");
        //Kit.display(rootDirFiles);

        for (File dir : rootDirFiles) {

            if (dir.listFiles() == null) continue;
            for (File file : dir.listFiles()) {
                removePackageFromFile(file, dir.getName());
            }
        }

    }

    private static File[] getSpecifiedDirs(File[] rootDirFiles, String name) {

        ArrayList<File> files = new ArrayList<>();
        for (File file : rootDirFiles) {
            if (file.isDirectory() && file.getName().contains(name)) {
                files.add(file);
            }
        }
        return files.toArray(new File[files.size()]);
    }

    private static void removePackageFromFile(File file, String name) {

        String lineSeparator = System.getProperty("line.separator");
        String packageString = "package " + name + ";";
        String buffer = "";
        boolean hasPackage = false;
        try (Scanner input = new Scanner(file)) {

            while (input.hasNext()) {
                String s = input.nextLine();
                if (s.contains(packageString)) {
                    hasPackage = true;
                } else {
                    buffer += s + lineSeparator;
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        if (!hasPackage) {
            System.out.println(packageString +" not found in " + file.getAbsolutePath());
            return; // Writing to file will be unnecessary
        }
        System.out.println(buffer);
        try (PrintWriter out = new PrintWriter(file)) {

            out.write(buffer);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }


}
