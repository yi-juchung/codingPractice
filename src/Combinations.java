import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    static public List<List<Integer>> combine(int n, int k) {
        List<Integer> cur = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        helper(1,n,k,cur,res);

        return res;
    }

    static public void helper (int s,int n, int k, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i=s;i<=n;i++) {
            cur.add(i);
            helper(i+1,n,k,cur,res);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String [ ] args) {
        for (List<Integer> l : combine(4,2)) {
            StringBuilder sb = new StringBuilder();
            for (int i : l) {
                sb.append(i+",");
            }
            System.out.println(sb);
        }
    }
}
