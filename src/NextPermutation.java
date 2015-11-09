import java.util.Arrays;

public class NextPermutation {
    static public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        int less = nums.length-2;
        for (;less >= 0;less--) {
            if (nums[less] < nums[less+1]) {
                break;
            }
        }

        if (less == -1) {
            Arrays.sort(nums);
            return;
        }

        int swp = less+1;

        for (int i=less+1;i<nums.length;i++) {
            if (nums[i] > nums[less])
                swp = i;
        }

        int temp = nums[swp];
        nums[swp] = nums[less];
        nums[less] = temp;

        Arrays.sort(nums,less+1,nums.length);
    }

    public static void main(String [ ] args) {
        int [] nums = new int []{7,2,5,3,2,1};
        nextPermutation(nums);
        for(int i : nums) {
            System.out.print(i);
        }
    }
}
