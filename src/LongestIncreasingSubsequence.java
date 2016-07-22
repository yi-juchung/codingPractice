import java.util.Arrays;

public class LongestIncreasingSubsequence {
    static public int lengthOfLIS(int[] nums) {
        int [] dp = new int [nums.length];
        int len = 0;

        for (int num : nums) {
            int idx = Arrays.binarySearch(dp,0,len,num);
            if (idx < 0) {
                idx = -(idx+1);
            }

            dp[idx] = num;
            if (len == idx) {
                len++;
            }
        }

        return len;
    }

    public static void main(String [ ] args) {
        int [] nums = new int [] {
                10, 9, 2, 5, 3, 7, 101, 18
        };

        System.out.println(lengthOfLIS(nums));
    }
}
