import java.util.*;

public class ShoppingBasket
{
    private Map<String, Purchase> purchases;
    
    public ShoppingBasket()
    {
        purchases = new HashMap<String, Purchase>();
    }
    
    public void add(String product, int price)
    {
        if(!purchases.containsKey(product))
            purchases.put(product, new Purchase(product,1,price));
        else
            purchases.get(product).increaseAmount();
    }
    
    public int price()
    {
        int total = 0;
        for(Purchase p : purchases.values())
        {
            total += p.price();
        }
        return total;
    }
    
    public void print()
    {
        for(Purchase p : purchases.values())
        {
            System.out.println(p);
        }
    }
}