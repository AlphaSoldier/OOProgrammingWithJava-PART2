import java.io.File;
import java.util.*;

public class Printer
{
    private File file;
    private Scanner reader;
    
    public Printer(String fileName) throws Exception
    {
        file = new File(fileName);
        reader = null;
    }
    
    public void printLinesWhichContain(String word) throws Exception
    {
        reader = new Scanner(file, "UTF-8");
        String s = "";
        if(word.isEmpty())
        {
            while(reader.hasNextLine())
            {
                String line = reader.nextLine();
                s += line;
                s += "\n";
            }
        }
        else
        {
            while(reader.hasNextLine())
            {
                String line = reader.nextLine();
                    if(line.contains(word))
                    {
                        s += line;
                        s += "\n";
                    }
            }
        }
        System.out.print(s);
        reader.close();
    }
}