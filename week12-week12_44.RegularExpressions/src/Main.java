public class Main {

    public static void main(String[] args) {
        // write test code here
    }
    
    public static boolean isAWeekDay(String string)
    {
        if(string.matches("(mon|tue|wed|thu|fri|sat|sun)"))
            return true;
        return false;
    }
    
    public static boolean allVowels(String string)
    {
        if(string.matches("[aeiouäöy]*"))
            return true;
        return false;
    }
    
    public static boolean clockTime(String string)
    {
        if(string.matches("((0|1){1}[0-9]{1}|(2){1}[0-3]{1}):{1}[0-5]{1}[0-9]{1}:{1}[0-5]{1}[0-9]{1}"))
            return true;
        return false;
    }
}
