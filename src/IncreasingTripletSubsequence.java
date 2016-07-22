public class IncreasingTripletSubsequence {
//    static public boolean increasingTriplet(int[] nums) {
//        if (nums.length < 3)
//            return false;
//
//        int [] dp = new int [nums.length];
//        dp[0] = 1;
//
//        for (int i=0;i<dp.length;i++) {
//            dp[i] = 1;
//            for (int j=0;j<=i-1;j++) {
//                if (nums[i] > nums[j]) {
//                    dp[i] = Math.max(dp[j]+1,dp[i]);
//                }
//            }
//        }
//
//        for (int i=0;i<dp.length;i++) {
//            if (dp[i] >= 3) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    static public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int small = nums[0];
        int mid = Integer.MAX_VALUE;

        for (int i=1;i<nums.length;i++) {
            if (nums[i] > mid) {
                return true;
            }

            if (nums[i] < mid && nums[i] > small) {
                mid = nums[i];
            } else if (nums[i] < small) {
                small = nums[i];
            }
        }

        return false;
    }

    public static void main(String [ ] args) {
        int [] nums = new int[] {1, 2, 3, 4, 5};
        System.out.println(increasingTriplet(nums));

        nums = new int[] {5, 4, 3, 2, 1};
        System.out.println(increasingTriplet(nums));

        nums = new int[] {2,1,5,0,4,6};
        System.out.println(increasingTriplet(nums));

        nums = new int[] {5,1,5,5,2,5,4};
        System.out.println(increasingTriplet(nums));
    }
}
