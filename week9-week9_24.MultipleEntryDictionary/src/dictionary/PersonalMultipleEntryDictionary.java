package dictionary;

import java.util.*;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary
{
    private Map<String, Set<String>> words;
    
    public PersonalMultipleEntryDictionary()
    {
        words = new HashMap<String, Set<String>>();
    }
    
    @Override
    public void add(String word, String entry)
    {
        if(!words.containsKey(word))
            words.put(word, new HashSet<String>());
        
        words.get(word).add(entry);
    }
    
    @Override
    public Set<String> translate(String word)
    {
        return words.get(word);
    }
    
    @Override
    public void remove(String word)
    {
        words.remove(word);
    }
}