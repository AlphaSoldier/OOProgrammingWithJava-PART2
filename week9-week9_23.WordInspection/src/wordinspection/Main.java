package wordinspection;

import java.io.*;

public class Main {

    public static void main(String[] args)
    {
        // test your code here

        File file = new File("src/shortList.txt");
        // all words are in file src/wordList.txt
        
        WordInspection inspector = null;
        
        try
        {
            inspector = new WordInspection(file);
        }
        catch(Exception e)
        {
            System.out.println("File Not Found!");
        }
        
        System.out.println(inspector.wordCount());
        System.out.println(inspector.wordsContainingZ());
        System.out.println(inspector.wordsEndingInL());
        System.out.println(inspector.palindromes());
        System.out.println(inspector.wordsWhichContainAllVowels());

    }
}
