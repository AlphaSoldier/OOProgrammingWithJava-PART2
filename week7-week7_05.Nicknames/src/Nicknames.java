import java.util.HashMap;
import java.util.Map;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations requested in the assignment here!
        HashMap<String,String> names = new HashMap<String,String>();
        
        names.put("matti", "mage");
        names.put("mikael", "mixu");
        names.put("arto","arppa");
        
        System.out.println(names.get("mikael"));
    }

}
