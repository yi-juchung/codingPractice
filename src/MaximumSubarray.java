public class MaximumSubarray {
    static public int maxSubArray(int[] nums) {
        if (nums.length < 1)
            return Integer.MIN_VALUE;

        int [] dp = new int[nums.length];
        dp[0] = nums[0];

        int curMax = dp[0];

        for (int i=1;i<nums.length;i++) {
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1]+nums[i];
            } else {
                dp[i] = nums[i];
            }

            if (dp[i] > curMax)
                curMax = dp[i];
        }

        return curMax;
    }

    public static void main(String [ ] args) {
        int[] intArray = new int[] {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(intArray));
    }
}
