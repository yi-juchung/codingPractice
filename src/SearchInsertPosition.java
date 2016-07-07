public class SearchInsertPosition {
    static public int searchInsert(int[] nums, int target) {
        return helper(nums, target, 0, nums.length-1);
    }

    static public int helper(int [] nums, int target, int beg, int end) {
        if (beg > end) {
            return end+1;
        }

        int mid = beg+(end-beg)/2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return helper(nums,target,mid+1,end);
        } else {
            return helper(nums,target,beg,mid-1);
        }
    }

    public static void main(String [ ] args) {
        int [] nums = new int [] {1,3,5,6};

        System.out.println(searchInsert(nums,5));
        System.out.println(searchInsert(nums,2));
        System.out.println(searchInsert(nums,7));
        System.out.println(searchInsert(nums,0));
    }
}
