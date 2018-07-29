public class Calculator
{
    private final Reader reader;
    private int calculations;
    
    public Calculator()
    {
        reader = new Reader();
        calculations = 0;
    }
    
    public void start()
    {
        while(true)
        {
            System.out.print("command: ");
            String command = reader.readString();
            if(command.equals("end"))
                break;
            if(command.equals("sum"))
                sum();
            if(command.equals("difference"))
                difference();
            if(command.equals("product"))
                product();
        }
        statistics();
    }
    
    private void sum()
    {
        int values[] = getValues();
        System.out.println("sum of the values " + (values[0] + values[1]));
        calculations++;
    }
    
    private void difference()
    {
        int values[] = getValues();
        System.out.println("difference of the values " + (values[0] - values[1]));
        calculations++;
    }
    
    private void product()
    {
        int values[] = getValues();
        System.out.println("product of the values " + (values[0] * values[1]));
        calculations++;
    }
    
    private void statistics()
    {
        System.out.println("Calculations done " + calculations);
    }
    
    private int[] getValues()
    {
        int[] values = {0,0};
        System.out.print("value1: ");
        values[0] = reader.readInteger();
        System.out.print("value2: ");
        values[1] = reader.readInteger();
        return values;
    }
}
