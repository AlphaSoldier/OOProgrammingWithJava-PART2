package file;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception
    {
        // test your code here

        File file = new File("src/testfile.txt");
        Analysis analyser = new Analysis(file);
        System.out.println("Lines: " + analyser.lines());
        System.out.println("Characters: " + analyser.characters());
    }
}
