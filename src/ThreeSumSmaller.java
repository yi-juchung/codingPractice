public class ThreeSumSmaller {
    static int threeSumSmaller(int [] nums, int target) {
        if (nums.length < 3)
            return 0;

        int res = 0;
        for (int i=0;i<nums.length-2;i++) {
            int j=i+1;
            int k=nums.length-1;

            while (j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if (sum < target) {
                    res += k-j;
                    break;
                } else if (sum >= target) {
                    k--;
                }
            }
        }

        return res;
    }

    public static void main(String [ ] args) {
        int [] val = new int []{-2, 0, 1, 3};

        System.out.println(threeSumSmaller(val,2));
    }
}
