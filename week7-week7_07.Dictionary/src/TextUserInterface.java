import java.util.*;

public class TextUserInterface
{
    private Scanner reader;
    private Dictionary dictionary;
    
    public TextUserInterface(Scanner reader, Dictionary dictionary)
    {
        this.reader = reader;
        this.dictionary = dictionary;
    }
    
    public void start()
    {
        System.out.println("Statement:\n  quit - quit the text user interface");
        System.out.println("  translate - asks a word and prints its translation");
        System.out.println("  quit - quits the text user interface\n");
        while(true)
        {
            System.out.print("Statement: ");
            String command = reader.nextLine();
            if(command.equals("quit"))
                break;
            else if(command.equals("add"))
                add();
            else if(command.equals("translate"))
                translate();
            else
                System.out.println("Unknown statement\n");
        }
        System.out.println("Cheers!");
    }
    
    public void add()
    {
        System.out.print("In Finnish: ");
        String finnish = reader.nextLine();
        System.out.print("Translation: ");
        String english = reader.nextLine();
        
        dictionary.add(finnish, english);
        System.out.println("");
    }
    
    public void translate()
    {
        System.out.print("Give a word: ");
        String word = reader.nextLine();
        System.out.println("Translation: " + dictionary.translate(word) + "\n");
    }
}