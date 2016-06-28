import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    public static class Logger {
        Map<String, Integer> limitMap;

        public Logger() {
            limitMap = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            boolean ablePrint = true;

            if (limitMap.containsKey(message) && limitMap.get(message)+10 > timestamp) {
                ablePrint = false;
            } else {
                limitMap.put(message,timestamp);
            }

            return ablePrint;
        }
    }



    public static void main(String [ ] args) {
        Logger logger = new Logger();

        System.out.println(logger.shouldPrintMessage(1,"foo"));
        //returns true;
        System.out.println(logger.shouldPrintMessage(2,"bar"));
        //returns true;
        System.out.println(logger.shouldPrintMessage(3,"foo"));
        //returns false;
        System.out.println(logger.shouldPrintMessage(8,"bar"));
        //returns false;
        System.out.println(logger.shouldPrintMessage(10,"foo"));
        //returns false;
        System.out.println(logger.shouldPrintMessage(11,"foo"));
        //returns true;
    }
}
