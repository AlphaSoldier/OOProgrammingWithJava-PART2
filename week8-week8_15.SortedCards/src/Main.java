
public class Main {

    public static void main(String[] args) {
        // write some test code here
        Hand hand = new Hand();

  hand.add( new Card(12, Card.HEARTS) );
  hand.add( new Card(14, Card.DIAMONDS) );
  hand.add( new Card(2, Card.SPADES) );
  hand.add( new Card(2, Card.CLUBS) );

  hand.sort();

  hand.print();
    }
}
