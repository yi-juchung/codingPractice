import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FactorCombinations {
    static public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new LinkedList<>();

        helper(n,new LinkedList<>(),res, 2);

        return res;
    }

    static public void helper (int n, List<Integer> cur, List<List<Integer>> res, int mod) {
        if (n==1) {
            if (cur.size() > 1) {
                res.add(new ArrayList(cur));
            }
            return;
        }

        for (int i=mod;i<=n;i++) {
            if (n%i == 0) {
                cur.add(i);
                helper(n/i,cur,res,i);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static void main(String [ ] args) {
        for (List<Integer> is : getFactors(8)) {
            StringBuilder sb = new StringBuilder();
            for (int i : is) {
                sb.append(i+",");
            }
            System.out.println(sb);
        }

        for (List<Integer> is : getFactors(32)) {
            StringBuilder sb = new StringBuilder();
            for (int i : is) {
                sb.append(i+",");
            }
            System.out.println(sb);
        }
    }
}
