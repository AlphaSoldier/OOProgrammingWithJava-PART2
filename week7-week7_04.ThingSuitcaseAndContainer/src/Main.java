public class Main {

    public static void main(String[] args) {
        // use this main class to test your program!
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }
    
    public static void addSuitcasesFullOfBricks(Container container)
    {
        for (int i = 1; i <= 100; i++)
        {
            Thing t = new Thing("brick",i);
            Suitcase s = new Suitcase(100);
            s.addThing(t);
            container.addSuitcase(s);
        }
    }
}
