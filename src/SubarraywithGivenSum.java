public class SubarraywithGivenSum {
    public static int [] findSubarray(int [] nums, int target) {
        int i = 0;
        int j = 0;
        int curSum = nums[0];

        for (j = 1; j <= nums.length; j++) {

            while (curSum > target && i<j-1) {
                curSum -= nums[i];
                i++;
            }

            if (curSum == target) {
                return new int []{i,j-1};
            }

            if (j<nums.length) {
                curSum += nums[j];
            }
        }

        return new int []{-1,-1};
    }

    public static void main(String [ ] args) {
        int [] nums = new int []{1, 4, 20, 3, 10, 5};

        // Sum found between indexes 2 and 4
        for (int i : findSubarray(nums,33)){
            System.out.println(i);
        }

        nums = new int []{1, 4, 0, 0, 3, 10, 5};

        // Sum found between indexes 1 and 4
        for (int i : findSubarray(nums,7)){
            System.out.println(i);
        }

        nums = new int []{1, 4};

        // none
        for (int i : findSubarray(nums,0)){
            System.out.println(i);
        }
    }
}
