package util;

public class IDGenerator {
    private static int idCounter = 0;

    public static int getNextIdCounter(){
        return  ++idCounter;
    }
}
