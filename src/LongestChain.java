import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LongestChain {
    static public int longestLength(String [] input) {

        HashMap<Character, List<String>> start = new HashMap<Character, List<String>>();

        for(String s : input) {
            List<String> list;

            if (start.containsKey(s.charAt(0))) {
                list = start.get(s.charAt(0));
            } else {
                list = new LinkedList<String>();
            }
            list.add(s);

            start.put(s.charAt(0), list);
        }

        HashSet<String> visited = new HashSet<String>();

        int maxPath = 0;

        for (String s : input) {
            visited.add(s);
            int cur = travel(s.charAt(s.length()-1), start, visited, 1);
            visited.remove(s);

            if (cur > maxPath)
                maxPath = cur;
        }

        return maxPath;
    }

    public static int travel(Character c, HashMap<Character, List<String>> start, HashSet<String> visited, int cur) {
        if (!start.containsKey(c)) {
            return cur;
        }

        int curMax = 0;
        for (String s : start.get(c)) {
            if (visited.contains(s))
                continue;

            visited.add(s);
            int temp = travel(s.charAt(s.length()-1), start, visited, cur+1);
            visited.remove(s);

            if (temp > curMax)
                curMax = temp;
        }

        return curMax;
    }

    public static void main(String [ ] args) {

        String [] input = new String [] {"peas","sugar", "rice" ,"soup"};

        System.out.println(longestLength(input));
    }
}
