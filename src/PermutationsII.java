import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        permuteHelper(nums, 0, res);
        return res;
    }

    public static void permuteHelper(int [] nums, int start, List<List<Integer>> res) {
        if (start == nums.length) {
            res.add(generateList(nums));
            return;
        }

        for (int i=start;i<nums.length;i++) {
            if (i != start && nums[i] == nums[i-1]) {
                continue;
            }

//            if (i != start && nums[start] == nums[i]) {
//                continue;
//            }

            swap(nums,start, i);
            permuteHelper(nums,start+1,res);
            swap(nums,start, i);
        }
    }

    public static void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

//    public static List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> res = new LinkedList<List<Integer>>();
//        Arrays.sort(nums);
//        permuteHelper(nums, new int[nums.length], new boolean[nums.length], 0, res);
//        return res;
//    }
//
//    public static void permuteHelper(int [] nums, int [] ans, boolean [] used, int start, List<List<Integer>> res) {
//        if (start == nums.length) {
//            res.add(new LinkedList<Integer>());
//            return;
//        }
//
//        for (int i=0;i<nums.length;i++) {
//            if (used[i] || (i > 0 && nums[i-1] == nums[i] && !used[i-1])) {
//                continue;
//            }
//
//            used[i] = true;
//            ans[start] = nums[i];
//            permuteHelper(nums,ans,used,start+1,res);
//            used[i] = false;
//        }
//    }

    public static List<Integer> generateList(int [] nums) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i:nums) {
            list.add(i);
        }

        return list;
    }

    public static void main(String [ ] args) {
        int [] nums = new int[] {1,1,3};

        for (List<Integer> l : permuteUnique(nums)) {
            for (int i:l) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
