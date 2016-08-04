import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
    static public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        helper(candidates,0,target,new LinkedList<>(),res);

        return res;
    }

    static public void helper (int [] cand, int start, int target, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        } else if (start >= cand.length) {
            return;
        }

        for (int i=start;i<cand.length;i++) {
            if (i != start && cand[i] == cand[i-1] || cand[i] > target) {
                continue;
            }

            int len = cur.size();
            cur.add(cand[i]);
            helper(cand,i+1,target-cand[i], cur, res);
            cur.remove(len);
        }
    }

    public static void main(String [ ] args) {
        int [] nums = new int []{10, 1, 2, 7, 6, 1, 5};

        for (List<Integer> l : combinationSum2(nums,8)) {
            System.out.println(l);
        }
    }
}
