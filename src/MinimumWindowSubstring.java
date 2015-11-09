import java.util.HashMap;

public class MinimumWindowSubstring {
    static public String minWindow(String s, String t) {

        String res = "";
        if (s == null || t == null || s.length() < t.length()) {
            return res;
        }

        HashMap<Character,Integer> counts = new HashMap<Character, Integer>();

        for (Character c : t.toCharArray()) {
            if (counts.containsKey(c)) {
                counts.put(c,counts.get(c)+1);
            } else {
                counts.put(c,1);
            }
        }

        HashMap<Character,Integer> windowCounts = new HashMap<Character, Integer>();
        int len = t.length();
        int minLen = Integer.MAX_VALUE;
        int charCount = 0, minStart = -1, minEnd = -1;

        for (int start = 0, end = 0;end < s.length();end++) {
            Character c = s.charAt(end);
            if (counts.containsKey(c)) {
                windowCounts.put(c,windowCounts.containsKey(c)?windowCounts.get(c)+1:1);

                if (windowCounts.get(c) <= counts.get(c)) {
                    charCount++;
                }
            }

            if (charCount >= len) {
                Character c2 = s.charAt(start);
                while (!counts.containsKey(c2) || windowCounts.get(c2) > counts.get(c2)) {
                    if (windowCounts.containsKey(c2)) {
                        windowCounts.put(c2,windowCounts.get(c2)-1);
                    }
                    start++;
                    if (start > end)
                        break;
                    c2 = s.charAt(start);
                }

                if (end-start+1 < minLen) {
                    minLen = end-start+1;
                    minStart = start;
                    minEnd = end;
                }
            }
        }

        return (minStart == -1)?res:s.substring(minStart,minEnd+1);
    }

    public static void main(String [ ] args) {

        // BANC
        System.out.print(minWindow("ADOBECODEBANC", "ABC"));
    }
}
