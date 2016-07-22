import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII {
    static public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>());
        Arrays.sort(nums);

        int begin = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i - 1]) {
                begin = 0;
            }

            int size = res.size();
            for(int j = begin; j < size; j++){
                List<Integer> cur = new ArrayList<>(res.get(j));
                cur.add(nums[i]);
                res.add(cur);
            }
            begin = size;
        }

        return res;
    }

    public static void main(String [ ] args) {
        int [] cit = new int [] {1,2,2};

        for (List<Integer> list : subsetsWithDup(cit)) {
            for (int i : list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
