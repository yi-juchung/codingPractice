import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumberII {
    static public List<String> findStrobogrammatic(int n) {
        Map<Integer, Integer> check = new HashMap<>();
        check.put(0,0);
        check.put(1,1);
        check.put(6,9);
        check.put(8,8);
        check.put(9,6);

        List<String> res = new LinkedList<>();
        helper(n,new StringBuilder(), check, res);

        return res;
    }

    static public void helper (int n, StringBuilder sb, Map<Integer, Integer> m,List<String> l) {
        if (n == 0) {
            l.add(sb.toString());
            return;
        } else if (n==1) {
            int mIdx =sb.length()/2;
            sb.insert(mIdx,0);
            l.add(sb.toString());
            sb.deleteCharAt(mIdx);
            sb.insert(mIdx,1);
            l.add(sb.toString());
            sb.deleteCharAt(mIdx);
            sb.insert(mIdx,8);
            l.add(sb.toString());
            sb.deleteCharAt(mIdx);
            return;
        }

        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if (e.getKey() == 0 && (n == 2 || n == 3)) {
                continue;
            }

            sb.append(e.getValue());
            sb.insert(0,e.getKey());
            helper(n-2,sb,m,l);
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(0);
        }
    }

    public static void main(String [ ] args) {
        for (String s: findStrobogrammatic(3)) {
            System.out.println(s);
        }
    }
}
