import java.util.*;

public class Dictionary
{
    private HashMap<String, String> dictionary;
    
    public Dictionary()
    {
        dictionary = new HashMap<String, String>();
    }
    
    public String translate(String word)
    {
        if(dictionary.containsKey(word))
            return dictionary.get(word);
        return null;
    }
    
    public void add(String word, String translation)
    {
        if(!dictionary.containsKey(word))
            dictionary.put(word, translation);
    }
    
    public int amountOfWords()
    {
        return dictionary.size();
    }
    
    public ArrayList<String> translationList()
    {
        ArrayList<String> translationList = new ArrayList<String>();
        String keyValue = "";
        for(String s : dictionary.keySet())
        {
             keyValue = s + " = " + dictionary.get(s);
             translationList.add(keyValue);
        }
        return translationList;
    }
}