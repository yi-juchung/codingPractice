public class SearchinRotatedSortedArrayII {
    static public boolean search(int[] nums, int target) {
        if (nums.length < 1)
            return false;

        return helper(nums, 0, nums.length-1, target);
    }

    static public boolean helper(int[] nums, int start, int end, int target) {
        if (start == end) {
            return (nums[start] == target);
        } else if (start > end) {
            return false;
        }

        int mid = start + (end-start)/2;

        if (target == nums[mid]) {
            return true;
        } else if (nums[mid] < nums[end]) {
            if (target < nums[mid]) {
                return helper(nums, start, mid-1, target);
            }
        } else if (nums[mid] > nums[end]) {
            if (target > nums[mid]) {
                return helper(nums, mid+1, end, target);
            }
        }

        boolean checkLeft = helper(nums, start, mid-1, target);
        boolean checkRight = helper(nums, mid+1, end, target);

        return checkLeft || checkRight;
    }

    public static void main(String [ ] args) {
        int [] num = {4,5,6,7,1,2,3};

        System.out.print(search(num, 8));
    }
}
