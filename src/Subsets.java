import java.util.LinkedList;
import java.util.List;

public class Subsets {
    static public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        helper(nums,0,new LinkedList<>(),res);

        return res;
    }

    static public void helper(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res) {
        if (idx == nums.length) {
            List<Integer> newClone = new LinkedList<>();
            for (Integer i : cur) {
                newClone.add(i);
            }
            res.add(newClone);
            return;
        }

        int len = cur.size();
        cur.add(nums[idx]);
        helper(nums,idx+1,cur,res);
        cur.remove(len);
        helper(nums,idx+1,cur,res);
    }

    public static void main(String [ ] args) {
        int [] cit = new int [] {1,2,3};

        for (List<Integer> list : subsets(cit)) {
            for (int i : list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
