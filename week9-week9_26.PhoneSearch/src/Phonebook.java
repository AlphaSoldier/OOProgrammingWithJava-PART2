import java.util.*;

public class Phonebook
{
    private Map<String, Contact> phonebook;
    
    public Phonebook()
    {
        phonebook = new HashMap<String, Contact>();
    }
    
    public void addContact(Scanner reader)
    {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String phone = reader.nextLine();
        
        if(!phonebook.containsKey(name))
            phonebook.put(name, new Contact(name, phone));
        else
        {
            phonebook.get(name).addPhone(phone);
        }
        System.out.println("");
    }
    
    public void searchByName(Scanner reader)
    {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        
        if(!phonebook.containsKey(name))
            System.out.println("  not found\n");
        else
            System.out.println(phonebook.get(name).getPhones());
    }
    
    public void searchByNumber(Scanner reader)
    {
        System.out.print("number: ");
        String number = reader.nextLine();
        boolean found = false;
        for(Contact contact : phonebook.values())
        {
            if(contact.searchPhones(number))
            {
                System.out.println("  " + contact.getName() + "\n");
                found = true;
                break;
            }
        }
        if(!found)
            System.out.println("  not found\n");
    }
    
    public void addAddress(Scanner reader)
    {
        System.out.print("whose address: ");
        String name = reader.nextLine();
        System.out.print("street: ");
        String street = reader.nextLine();
        System.out.print("city: ");
        String city = reader.nextLine();
        
        if(!phonebook.containsKey(name))
            phonebook.put(name, new Contact(name, ""));
        
        phonebook.get(name).setAddress(street, city);
    }
    
    public void searchInfo(Scanner reader)
    {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        if(!phonebook.containsKey(name))
            System.out.println("  not found");
        else
        {
            if(phonebook.get(name).isPhonesEmpty())
            {
                System.out.println("  address: " + phonebook.get(name).getAddress());
                System.out.println("  phone number not found");
            }
            else
                System.out.println(phonebook.get(name).toString());
        }
    }
    
    public void deleteInfo(Scanner reader)
    {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        
        if(phonebook.containsKey(name))
            phonebook.remove(name);
        
        System.out.println("");
    }
    
    public void filteredSearch(Scanner reader)
    {
        System.out.print("keyword (if empty, all listed): ");
        String key = reader.nextLine();
        boolean found = false;
        List<String> sortedNames = getSortedNames();
        for(String name : sortedNames)
        {
            if(name.contains(key))
            {
                System.out.println("");
                System.out.println(" " + name);
                System.out.println(phonebook.get(name));
                found = true;
            }
        }
        for(Contact contact : phonebook.values())
        {
            if(contact.getAddress().contains(key))
            {
                System.out.println("");
                System.out.println(" " + contact.getName());
                System.out.println(contact.toString());
                found = true;
            }
        }
        if(!found)
        {
            System.out.println("  keyword not found\n");
        }
    }
    
    private List<String> getSortedNames()
    {
        List<String> names = new ArrayList<String>();
        for(String name : phonebook.keySet())
        {
            names.add(name);
        }
        Collections.sort(names);
        return names;
    }
}