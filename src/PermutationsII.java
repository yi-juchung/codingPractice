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
