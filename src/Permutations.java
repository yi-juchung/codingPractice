import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        permuteHelper(nums,0,res);
        return res;
    }

    public static void permuteHelper(int [] nums, int start, List<List<Integer>> res) {
        if (start >= nums.length) {
            res.add(generateList(nums));
            return;
        }

        for (int i=start;i<nums.length;i++) {
            swap(nums, start, i);
            permuteHelper(nums,start+1,res);
            swap(nums, start, i);
        }
    }

    public static void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<Integer> generateList(int [] nums) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i:nums) {
            list.add(i);
        }

        return list;
    }

    public static void main(String [ ] args) {
        int [] nums = new int[] {1,2,3};

        for (List<Integer> l : permute(nums)) {
            for (int i:l) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
