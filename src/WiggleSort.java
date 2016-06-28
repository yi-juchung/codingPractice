import java.util.Arrays;

public class WiggleSort {
    static public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i++){
            if((i % 2 == 1 && nums[i] < nums[i-1]) || (i % 2 == 0 && nums[i] > nums[i-1])){
                int tmp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = tmp;
            }
        }
    }

    public static void main(String [ ] args) {
        int [] nums = new int [] {3, 5, 2, 1, 6, 4};

        wiggleSort(nums);

        for (int i : nums ){
            System.out.println(i);
        }
    }
}
