package utils;

public class Random {

    public static int random(int maxPercent) {
        int result = (int) (Math.random() * maxPercent + 1);
       // System.out.println("Random = " + result);
        return result;
    }
}
