public class HouseRobberII {
    static public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }

        int [] picked = new int [nums.length];

        for (int i=0;i<nums.length-1;i++) {
            if (i == 0) {
                picked[i] = nums[i];
            } else if (i == 1) {
                picked[i] = Math.max(nums[i],nums[i-1]);
            } else {
                picked[i] = Math.max(nums[i]+picked[i-2],picked[i-1]);
            }
        }

        int curMax = picked[nums.length-2];

        for (int i=1;i<nums.length;i++) {
            if (i == 1) {
                picked[i] = nums[i];
            } else if (i == 2) {
                picked[i] = Math.max(nums[i],nums[i-1]);
            } else {
                picked[i] = Math.max(nums[i]+picked[i-2],picked[i-1]);
            }
        }

        curMax = Math.max(curMax,picked[nums.length-1]);

        return curMax;
    }

    public static void main(String [ ] args) {

        int [] num = new int[] {1,1,1};
        System.out.print(rob(num));
    }
}
