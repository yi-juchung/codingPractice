public class KthLargestElementinanArray {
    static public int findKthLargest(int[] nums, int k) {
        return helper(nums,0,nums.length-1,k);
    }

    static public int helper(int [] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int pivot = nums[start];

        int i = start+1;
        int j = end;

        while (i < j) {
            if (nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            } else {
                i++;
            }
        }

        if (nums[i] < pivot) {
            i--;
        }

        int t = nums[i];
        nums[i] = nums[start];
        nums[start] = t;
        int largeNum = (i-start+1);

        if ( largeNum == k ) {
            return pivot;
        } else if (largeNum > k) {
            return helper(nums, start, i-1, k);
        } else {
            return helper(nums, i+1, end, k-largeNum);
        }
    }

    public static void main(String [ ] args) {

//        int [] num = new int[] {3,2,1,5,6,4};
        int [] num = new int[] {1};
        System.out.print(findKthLargest(num, 1));
    }
}
