import java.util.Scanner;

public class Reader
{
    private Scanner reader;
    
    public Reader()
    {
        reader = new Scanner(System.in);
    }
    
    public String readString()
    {
        String s  = reader.nextLine();
        return s;
    }
    
    public int readInteger()
    {
        String s = reader.nextLine();
        int a = Integer.parseInt(s);
        return a;
    }
}
