public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
        printWithSmileys("a");
    }
    
    private static void printWithSmileys(String s)
    {
        String extraSpace = "";
        if(s.length() % 2 != 0)
            extraSpace = " ";
        String printed = ":) " + s + extraSpace + " :)";
        int boundarySmileys = printed.length() / 2;
        printSmileys(boundarySmileys);
        System.out.println(printed);
        printSmileys(boundarySmileys);
    }
    
    private static void printSmileys(int x)
    {
        for (int i = 0; i < x; i++)
        {
            System.out.print(":)");
        }
        System.out.println("");
    }

}
