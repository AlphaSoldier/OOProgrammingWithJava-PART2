import java.util.*;

public class VehicleRegister
{
    private HashMap<RegistrationPlate, String> owners;
    
    public VehicleRegister()
    {
        owners = new HashMap<RegistrationPlate, String>();
    }
    
    public boolean add(RegistrationPlate plate, String owner)
    {
        if(owners.containsKey(plate))
            return false;
        owners.put(plate, owner);
        return true;
    }
    
    public String get(RegistrationPlate plate)
    {
        String owner = null;
        owner = owners.get(plate);
        return owner;
    }
    
    public boolean delete(RegistrationPlate plate)
    {
        if(!owners.containsKey(plate))
            return false;
        owners.remove(plate);
        return true;
    }
    
    public void printRegistrationPlates()
    {
        for(RegistrationPlate rp : owners.keySet())
        {
            System.out.println(rp);
        }
    }
    
    public void printOwners()
    {
        ArrayList<String> ownerList = new ArrayList<String>();
        for(String s : owners.values())
        {
            if(!ownerList.contains(s))
                ownerList.add(s);
        }
        for(String s : ownerList)
        {
            System.out.println(s);
        }
    }
}