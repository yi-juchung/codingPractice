public class TwoSumII {

    static public int [] twoSum(int [] nums, int target) {
        int i =0;
        int j=nums.length-1;

        int [] res = new int[2];

        while(i<j) {
            int total = nums[i]+nums[j];
            if (total == target) {
                res[0] = i;
                res[1] = j;
                break;
            } else if (total > target) {
                j--;
            } else {
                i++;
            }
        }

        return res;
    }

    public static void main(String [ ] args) {
        int [] nums = new int [] {2,7,11,15};

        int [] res = twoSum(nums,9);

        System.out.println(res[0]+" "+res[1]);
    }
}
