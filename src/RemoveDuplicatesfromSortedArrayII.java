public class RemoveDuplicatesfromSortedArrayII {
    static public int removeDuplicates(int[] nums) {

        if (nums.length < 2) {
            return nums.length;
        }

        int end = 1;

        for (int i=2;i<nums.length;i++) {
            if (nums[i] != nums[end-1]) {
                nums[++end] = nums[i];
            }
        }

        return end+1;
    }

//    static public int removeDuplicates(int[] nums) {
//
//        if (nums.length < 2) {
//            return nums.length;
//        }
//
//        int curIdx = 1;
//        int newIdx = 1;
//
//        boolean sec = false;
//        int prevVal = nums[0];
//        while (curIdx < nums.length) {
//            int curVal = nums[curIdx];
//            if (curVal == prevVal) {
//                if (!sec) {
//                    sec = true;
//                    nums[newIdx++] = curVal;
//                }
//            } else {
//                sec = false;
//                nums[newIdx++] = curVal;
//            }
//
//            curIdx++;
//            prevVal = curVal;
//        }
//
//        return newIdx;
//    }

    public static void main(String [ ] args) {
        int [] nums = new int[] {1,1,1,2,2,3};

        System.out.println(removeDuplicates(nums));
    }
}
