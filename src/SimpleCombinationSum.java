import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SimpleCombinationSum {
    static public List<List<Integer>> combinationSum(int target) {
        List<List<Integer>> res = new LinkedList<>();

        helper(1,target,new LinkedList<>(), res);

        return res;
    }

    static public void helper (int num, int target,List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            List<Integer> clone = new ArrayList<>(cur);
            res.add(clone);
            return;
        } else if (target < 0) {
            return;
        }

        for (int i=num;i<=target;i++) {
            int idx = cur.size();
            cur.add(i);
            helper(i,target-i,cur,res);
            cur.remove(idx);
        }
    }

    public static void main(String [ ] args) {

        // 1,1,1,1
        // 1,1,2
        // 1,3
        // 2,2

        for ( List<Integer> ints : combinationSum(4)) {
            for (int i : ints) {
                System.out.println(i);
            }
            System.out.println();
        }
    }
}
