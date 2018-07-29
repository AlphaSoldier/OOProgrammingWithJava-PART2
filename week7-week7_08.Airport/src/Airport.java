import java.util.*;

public class Airport
{
    private HashMap<String, Plane> planes;
    private HashMap<String, Flight> flights;

    public Airport()
    {
        planes = new HashMap<String, Plane>();
        flights = new HashMap<String, Flight>();
    }
    
    public void addPlane(String id, int capacity)
    {
        planes.put(id,new Plane(id,capacity));
    }
    
    public void addFlight(String id, String from, String to)
    {
        Plane plane = planes.get(id);
        Flight flight = new Flight(plane, from, to);
        flights.put(flight.toString(), flight);
    }
    
    public void start(Scanner reader)
    {
        startAirport(reader);
        System.out.println("");
        startFlightService(reader);
        System.out.println("");
    }
    
    public void startAirport(Scanner reader)
    {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");
        while(true)
        {
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            System.out.print("> ");
            String input = reader.nextLine();
            if(input.equals("x"))
                break;
            inputHandlerAirport(input, reader);
        }
    }
    
    public void inputHandlerAirport(String input, Scanner reader)
    {
        if(input.equals("1"))
        {
            System.out.print("Give plane ID: ");
            String id = reader.nextLine();
            System.out.print("Give plane capacity: ");
            int capacity = Integer.parseInt(reader.nextLine());
            addPlane(id,capacity);
        }
        if(input.equals("2"))
        {
            System.out.print("Give plane ID: ");
            String id = reader.nextLine();
            System.out.print("Give departure airport code: ");
            String from = reader.nextLine();
            System.out.print("Give destination airport code: ");
            String to = reader.nextLine();
            addFlight(id,from,to);
        }
    }
    
    public void startFlightService(Scanner reader)
    {
        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println("");
        while(true)
        {
            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            System.out.print("> ");
            String input = reader.nextLine();
            if(input.equals("x"))
                break;
            inputHandlerFlightService(input, reader);
        }
    }
    
    public void inputHandlerFlightService(String input, Scanner reader)
    {
        if(input.equals("1"))
        {
            for(Plane p : planes.values())
                System.out.println(p);
        }
        if(input.equals("2"))
        {
            for(Flight f : flights.values())
                System.out.println(f);
        }
        if(input.equals("3"))
        {
            System.out.print("Give plane ID: ");
            String id = reader.nextLine();
            System.out.println(planes.get(id).toString());
        }
    }
}