package wordinspection;

import java.util.*;
import java.io.*;

public class WordInspection
{
    private Scanner reader;
    private List<String> fileToString;
    
    public WordInspection(File file) throws Exception
    {
        reader = new Scanner(file, "UTF-8");
        fileToString = new ArrayList<String>();
        while(reader.hasNextLine())
        {
            String line = reader.nextLine();
            fileToString.add(line);
        }
    }
    
    public int wordCount()
    {
        int wordCount = 0;
        for(String word : fileToString)
            wordCount++;
        return wordCount;
    }
    
    public List<String> wordsContainingZ()
    {
        List<String> wordsContainingZ = new ArrayList<String>();
        for(String word : fileToString)
        {
            if(word.contains("z"))
                wordsContainingZ.add(word);
        }
        return wordsContainingZ;
    }
    
    public List<String> wordsEndingInL()
    {
        List<String> wordsEndingInL = new ArrayList<String>();
        for(String word : fileToString)
        {
            if(word.charAt(word.length() - 1) == 'l')
                wordsEndingInL.add(word);
        }
        return wordsEndingInL;
    }
    
    public List<String> palindromes()
    {
        List<String> palindromes = new ArrayList<String>();
        for(String word : fileToString)
        {
            if(word.equals(this.palindrome(word)))
                palindromes.add(word);
        }
        return palindromes;
    }
    
    public List<String> wordsWhichContainAllVowels()
    {
        List<String> wordsWhichContainAllVowels = new ArrayList<String>();
        for(String word : fileToString)
        {
            if(wordContainsAllVowels(word))
                wordsWhichContainAllVowels.add(word);
        }
        return wordsWhichContainAllVowels;
    }
    
    private String palindrome(String word)
    {
        String palindrome = "";
        for (int i = word.length() - 1; i >= 0; i--)
            palindrome += word.charAt(i);
        return palindrome;
    }
    
    private boolean wordContainsAllVowels(String word)
    {
        return word.contains("a") && word.contains("e") && word.contains("i") && word.contains("o") && word.contains("u") && word.contains("y") && word.contains("ä") && word.contains("ö");
    }
}