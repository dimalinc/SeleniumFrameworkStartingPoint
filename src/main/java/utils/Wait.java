package utils;

public class Wait {

    public static void wait(int delay) {
        try {
            Thread.sleep(delay);
        } catch (Exception e) {}
    }
}
