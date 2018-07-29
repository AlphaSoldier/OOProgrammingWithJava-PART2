package tools;

import java.util.*;

public class PersonalDuplicateRemover implements DuplicateRemover
{
    private Set<String> words;
    private int duplicates;
    
    public PersonalDuplicateRemover()
    {
        words = new HashSet<String>();
        duplicates = 0;
    }
    
    @Override
    public void add(String characterString)
    {
        if(words.contains(characterString))
            duplicates++;
        words.add(characterString);
    }
    
    @Override
    public int getNumberOfDetectedDuplicates()
    {
        return this.duplicates;
    }
    
    @Override
    public Set<String> getUniqueCharacterStrings()
    {
        return words;
    }
    
    @Override
    public void empty()
    {
        duplicates = 0;
        words.clear();
    }
}