public class ExistSuminArray {
    static public boolean exist (int [] nums, int target) {
        return helper(nums,0,0,target,new boolean [nums.length]);
    }

    static public boolean helper (int [] nums, int idx, int curSum, int target, boolean [] pick) {
        if (curSum == target) {
            return true;
        } else if (idx == nums.length) {
            return false;
        } else {
            pick[idx] = true;
            curSum += nums[idx];
            boolean found = helper(nums,idx+1,curSum,target,pick);

            if (found) {
                return true;
            }
            curSum -= nums[idx];
            pick[idx] = false;
            found = helper(nums,idx+1,curSum,target,pick);

            return found;
        }
    }

    public static void main(String [ ] args) {
        int [] nums = new int []{1,2,5,6,10,12,17};

        System.out.println(exist(nums,15));

        nums = new int []{1,2,5,6,10};

        System.out.println(exist(nums,4));
    }
}
