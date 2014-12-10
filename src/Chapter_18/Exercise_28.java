package Chapter_18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * (Nonrecursive directory size)
 *  Rewrite Listing 18.7, DirectorySize.java, without using recursion.
 *
 * Created by Luiz Arantes Sa on 12/9/14.
 */
public class Exercise_28 {

    public static void main(String[] args) throws FileNotFoundException {

        if (args.length != 1) {
            System.out.println("Usage: directoryOrFilePath");
            System.exit(0);
        }

        File file = new File(args[0]);
        if (!file.isDirectory() && !file.isFile()) {
            System.out.println(file.getAbsoluteFile() + " is not a file or directory");
            System.exit(0);
        }


        long size = 0;
        ArrayList<File> allFiles = new ArrayList<>(500);
        allFiles.add(file);
        for (int i = 0; i < allFiles.size(); i++) {
            File f = allFiles.get(i);
            if (f.isFile())
                size += f.length();
            else if (f.listFiles()!= null && f.listFiles().length != 0)
                Collections.addAll(allFiles, f.listFiles());
        }

        System.out.println("Total size = " + size);
    }

}
