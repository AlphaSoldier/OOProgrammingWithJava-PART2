import java.util.*;

public class Contact implements Comparable<Contact>
{
    private String name;
    private Set<String> phones;
    private String address;
    
    public Contact(String name, String phone)
    {
        this.name = name;
        phones = new HashSet<String>();
        if(!phone.isEmpty())
            phones.add(phone);
        address = "unknown";
    }

    public String getName() {
        return name;
    }

    public String getPhones() {
        String result = "";
        if(isPhonesEmpty())
            return "  not found";
        for(String phone : phones)
        {
            result += "   " + phone + "\n";
        }
        return result;
    }
    
    public boolean isPhonesEmpty()
    {
        return phones.isEmpty();
    }
    
    public boolean searchPhones(String phone)
    {
        for(String s : phones)
        {
            if(s.equals(phone))
                return true;
        }
        return false;
    }

    public String getAddress() {
        return address;
    }
    
    public void addPhone(String phone)
    {
        phones.add(phone);
    }
    
    public void setAddress(String street, String city)
    {
        address = street + " " + city;
    }
    
    @Override
    public String toString()
    {
        String addressHandler = "";
        if(address.equals("unknown"))
            addressHandler = "  address ";
        else
            addressHandler = "  address: ";
        return addressHandler + this.getAddress() + "\n  phone numbers:\n" + this.getPhones();
    }
    
    @Override
    public int compareTo(Contact contact)
    {
        return this.getName().compareTo(contact.getName());
    }
}