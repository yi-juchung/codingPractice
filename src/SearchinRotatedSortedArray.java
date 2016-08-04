public class SearchinRotatedSortedArray {
    static public int search(int[] nums, int target) {
        if (nums.length < 1)
            return -1;

        return helper(nums, 0, nums.length-1, target);
    }

    static public int helper(int[] nums, int start, int end, int target) {
        if (start == end) {
            return (nums[start] == target)?start:-1;
        } else if (start > end) {
            return -1;
        }

        int mid = start + (end-start)/2;

        if (target == nums[mid]) {
            return mid;
        } else if (nums[mid] < nums[end]) {
            if (target < nums[mid]) {
                return helper(nums, start, mid-1, target);
            }
        } else if (nums[mid] > nums[end]) {
            if (target > nums[mid]) {
                return helper(nums, mid+1, end, target);
            }
        }

        int checkLeft = helper(nums, start, mid-1, target);
        if (checkLeft != -1)
            return checkLeft;

        return helper(nums, mid+1, end, target);
    }

    public static void main(String [ ] args) {
        int [] num = {2,2,2,2,2,0,2,2};

        System.out.print(search(num, 0));
    }
}
