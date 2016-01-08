public class RangeSumQuery {
    int [] sums;

    public RangeSumQuery(int[] nums) {
        sums = new int [nums.length];
        int cur = 0;
        for (int i=0;i<nums.length;i++) {
            sums[i] = (cur += nums[i]);
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sums[j];
        } else {
            return sums[j]-sums[i-1];
        }
    }

    public static void main(String [ ] args) {
        int [] nums = new int[] {-2, 0, 3, -5, 2, -1};
        RangeSumQuery rsq = new RangeSumQuery(nums);

        System.out.println(rsq.sumRange(0,2));
    }
}
