import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    static public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> res = new HashMap<String, List<String>>();

        for (String s : strs) {
            String sorted = sortWord(s);

            List<String> que;
            if (res.containsKey(sorted)) {
                que = res.get(sorted);
                que.add(s);
            } else {
                que = new LinkedList<String>();
                que.add(s);
                res.put(sorted,que);
            }
        }

        List<List<String>> out = new LinkedList<List<String>>();

        for (Map.Entry<String,List<String>> e : res.entrySet()) {
            Collections.sort(e.getValue());
            out.add(e.getValue());
        }

        return out;
    }

    static public String sortWord(String s) {
        char [] chars = s.toCharArray();

        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String [ ] args) {
        String [] input = new String [] {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groups = groupAnagrams(input);

        for(List<String> cur : groups) {
            for(String s : cur) {
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }
}
