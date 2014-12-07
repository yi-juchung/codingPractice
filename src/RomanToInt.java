import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    static Map<Character, Integer> romanMap;

    static {
        romanMap = new HashMap<Character, Integer>();
        romanMap.put('M', 1000);
        romanMap.put('D', 500);
        romanMap.put('C', 100);
        romanMap.put('L', 50);
        romanMap.put('X', 10);
        romanMap.put('V', 5);
        romanMap.put('I', 1);
    }

    static public int romanToInt(String s) {
        return helper(s, 0, s.length());
    }

    static public int helper(String s, int begin, int end) {
        if (begin >= end)
            return 0;

        int largeIdx = -1;
        int curMaxVal = -1;
        for (int i = begin; i < end; i++) {
            if (romanMap.get(s.charAt(i)) > curMaxVal) {
                curMaxVal = romanMap.get(s.charAt(i));
                largeIdx = i;
            }
        }

        return curMaxVal+helper(s,largeIdx+1, end)-helper(s,begin, largeIdx);
    }

    public static void main(String [ ] args) {
        System.out.print(romanToInt("LXXXVIII"));
    }
}
