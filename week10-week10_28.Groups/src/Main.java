import movable.Organism;

public class Main {

    public static void main(String[] args) {
        // test your program here
        Organism organism = new Organism(20, 30);
     System.out.println(organism);
     organism.move(-10, 5);
     System.out.println(organism);
     organism.move(50, 20);
     System.out.println(organism);
    }
}
