package dictionary;

import java.util.*;
import java.io.*;

public class MindfulDictionary
{
    private Map<String,String> dict;
    private File f;
    private Scanner reader;
    
    public MindfulDictionary()
    {
        dict = new HashMap<String, String>();
    }
    
    public MindfulDictionary(String file) throws FileNotFoundException
    {
        this();
        f = new File(file);
    }
    
    public boolean load()
    {
        try
        {
            reader = new Scanner(f, "UTF-8");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
            return false;
        }
        while(reader.hasNextLine())
        {
            String line = reader.nextLine();
            String[] splitter = line.split(":");
            dict.put(splitter[0],splitter[1]);
        }
        reader.close();
        return true;
    }
    
    public void add(String word, String translation)
    {
        if(!dict.containsKey(word))
            dict.put(word, translation);
    }
    
    public String translate(String word)
    {
        if(dict.containsKey(word))
            return dict.get(word);
        if(dict.containsValue(word))
            return this.getByValue(word);
        return null;
    }
    
    public void remove(String word)
    {
        if(dict.containsKey(word))
            dict.remove(word);
        if(dict.containsValue(word))
            dict.remove(this.getByValue(word));
    }
    
    public boolean save()
    {   
        try{
            if(!dict.isEmpty())
            {
                FileWriter writer = new FileWriter(f);
                for(String key : dict.keySet())
                {
                    writer.write(key + ":" + dict.get(key) + "\n");
                }
                writer.close();
            }
        }
        catch(IOException e)
        {   
            System.out.println("File not found!");
            return false;
        }
        return true;
    }
    
    private String getByValue(String word)
    {
        for(String key : dict.keySet())
            {
                if(dict.get(key).equals(word))
                    return key;
            }
        return null;
    }
}