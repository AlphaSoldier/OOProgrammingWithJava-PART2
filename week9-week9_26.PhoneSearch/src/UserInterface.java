import java.util.*;

public class UserInterface
{
    private Phonebook pb;
    
    public UserInterface()
    {
        pb = new Phonebook();
    }
    
    public void start(Scanner reader)
    {
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit\n");
        while(true)
        {
            System.out.print("command: ");
            String command = reader.nextLine();
            if(command.equals("1"))
                pb.addContact(reader);
            else if(command.equals("2"))
                pb.searchByName(reader);
            else if(command.equals("3"))
                pb.searchByNumber(reader);
            else if(command.equals("4"))
                pb.addAddress(reader);
            else if(command.equals("5"))
                pb.searchInfo(reader);
            else if(command.equals("6"))
                pb.deleteInfo(reader);
            else if(command.equals("7"))
                pb.filteredSearch(reader);
            else if(command.equals("x"))
                break;
        }
    }
}