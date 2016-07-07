import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ShortestWordDistanceII {
    static class SWD {
        HashMap<String, List<Integer>> inner;

        public SWD (List<String> list) {
            inner = new HashMap<>();
            for (int i=0;i<list.size();i++) {
                List<Integer> ilist;
                if (inner.containsKey(list.get(i))) {
                    ilist = inner.get(list.get(i));
                } else {
                    ilist = new LinkedList<>();
                    inner.put(list.get(i), ilist);
                }
                ilist.add(i);
            }
        }

        public int shortest(String w1, String w2) {
            List<Integer> l1 = inner.get(w1);
            List<Integer> l2 = inner.get(w2);

            int i = 0;
            int j = 0;

            int curMin = Integer.MAX_VALUE;

            while(i<l1.size() && j<l2.size()) {
                curMin = Math.min(Math.abs(l1.get(i) - l2.get(j)), curMin);
                if (l1.get(i) < l2.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }

            return curMin;
        }
    }

    public static void main(String [ ] args) {
        List<String> strings = Arrays.asList("practice", "makes", "perfect", "coding", "makes");

        SWD s = new SWD(strings);


        // 3, 1
        System.out.println(s.shortest("coding", "practice"));
        System.out.println(s.shortest("makes", "coding"));
    }
}
