import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    static public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();

        helper(candidates, 0, new LinkedList<>(), res, target);

        return res;
    }

    static public void helper (int [] cand, int idx, List<Integer> cur, List<List<Integer>> res, int target) {
        if (target <= 0 || idx >= cand.length) {
            if (target == 0) {
                List<Integer> clone = new LinkedList<>();
                for (int i : cur) {
                    clone.add(i);
                }
                res.add(clone);
            }
            return;
        }

        int len = cur.size();
        cur.add(cand[idx]);
        helper(cand, idx, cur, res, target-cand[idx]);
        cur.remove(len);

        helper(cand, idx+1, cur, res, target);
    }

    public static void main(String [ ] args) {
        int [] nums = new int []{2, 3, 6, 7};
        for ( List<Integer> ints : combinationSum(nums,7)) {
            for (int i : ints) {
                System.out.println(i);
            }
            System.out.println();
        }
    }
}
