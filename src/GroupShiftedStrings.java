import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupShiftedStrings {

    static public List<List<String>> group(List<String> ss) {
        HashMap<String,List<String>> resMap = new HashMap<>();

        for (String s : ss) {
            List<String> inner;
            String k = hashKey(s);
            if (resMap.containsKey(k)) {
                inner = resMap.get(k);
            } else {
                inner = new LinkedList<>();
            }
            inner.add(s);
            resMap.put(k,inner);
        }

        List<List<String>> res = new LinkedList<>();

        for (List<String> l : resMap.values()) {
            Collections.sort(l);
            res.add(l);
        }

        return res;
    }

    static public String hashKey(String s) {
//        char [] arrays = new char[s.length()];
//
//        StringBuilder sb = new StringBuilder();
//        for (int i=1;i<arrays.length;i++) {
//            sb.append(arrays[i]-arrays[i-1]);
//            sb.append(':');
//        }
//
//        if (arrays.length == 1) {
//            sb.append(0);
//        }
//
//        return sb.toString();
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return "z";
        }
        char[] chars = s.toCharArray();
        int offset = 'z' - chars[0];
        for(int i = 0; i < chars.length; i++) {
            chars[i] += offset;
            if (chars[i] > 'z') {
                chars[i] -= 26;
            }
        }
        return new String(chars);
    }

    public static void main(String [ ] args) {

        List<String> ss = new LinkedList<>();
        ss.add("abc");
        ss.add("bcd");
        ss.add("acef");
        ss.add("xyz");
        ss.add("az");
        ss.add("ba");
        ss.add("a");
        ss.add("z");

        for (List<String> l : group(ss)) {
            for (String s:l ) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
