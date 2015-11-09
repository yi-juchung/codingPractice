import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LongestChain2 {
    static public int longestLength(String [] input) {

        TreeMap<Integer, Set<String>> lens = new TreeMap<Integer, Set<String>>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        int maxLen = 0;
        for (String s : input) {
            Set<String> list;
            int length = s.length();

            if (lens.containsKey(length)) {
                list = lens.get(length);
            } else {
                list = new HashSet<String>();
            }

            list.add(s);
            lens.put(length,list);

            if (length > maxLen) {
                maxLen = length;
            }
        }

        int max = 0;

        for (Map.Entry<Integer,Set<String>> e : lens.entrySet()) {
            if (e.getKey() <= max)
                break;

            for (String s : e.getValue()) {
                int curLen = find(s, lens, 1);

                if (curLen > max) {
                    max = curLen;
                }
            }
        }

//        for (int i=maxLen;i>=max;i--) {
//            if (lens.containsKey(i)) {
//                for (String s : lens.get(i)) {
//                    int curLen = find(s, lens, 1);
//
//                    if (curLen > max) {
//                        max = curLen;
//                    }
//                }
//            }
//        }

        return max;
    }

    public static int find(String s, TreeMap<Integer,Set<String>> lens, int len) {
        if (s.length() == 1) {
            return len;
        }

        Set<String> next;
        int length = s.length();

        if (lens.containsKey(length-1)) {
            next = lens.get(length-1);
        } else {
            return len;
        }

        int curMax = len;
        for (int i=0;i<length;i++) {
            String child = childString(s,i);

            if (next.contains(child)) {
                int cur = find(child, lens, len+1);

                if (cur > curMax) {
                    curMax = cur;
                }

                next.remove(child);
            }
        }

        return curMax;
    }

    public static String childString(String s, int i) {
        if (i == 0) {
            return s.substring(1);
        } else if (i == s.length()-1) {
            return s.substring(0, i);
        }

        String head = s.substring(0,i);
        String tail = s.substring(i+1);

        return head+tail;
    }

    public static void main(String [ ] args) {

        String [] input = new String [] {"a","ba","bca","bda","bdca","adsasdasda"};

        System.out.println(longestLength(input));
    }
}
