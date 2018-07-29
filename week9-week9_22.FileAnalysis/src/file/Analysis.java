package file;

import java.util.*;
import java.io.*;


public class Analysis
{
    private Scanner reader;
    private String fileToString;
    
    public Analysis(File file) throws Exception
    {
        reader = new Scanner(file, "UTF-8");
        fileToString = "";
        while(reader.hasNextLine())
        {
            String line = reader.nextLine();
            fileToString += line;
            fileToString += "\n";
        }
    }
    
    public int lines()
    {
        Scanner newReader = new Scanner(fileToString);
        int lines = 0;
        while(newReader.hasNextLine())
        {
            lines++;
            newReader.nextLine();
        }
        return lines;
    }
    
    public int characters()
    {
        return this.fileToString.length();
    }
}