public class SortColors {
//    static public void sortColors(int[] nums) {
//        int [] buckets = new int [3];
//
//        for (int i : nums) {
//            buckets[i]++;
//        }
//
//        int count = 0;
//        for (int i=0;i<3;i++) {
//            for (int j=0;j<buckets[i];j++) {
//                nums[count++] = i;
//            }
//        }
//    }

    static public void sortColors(int[] nums) {
        int zeroIdx = 0;
        int twoIdx = nums.length-1;

        for (int i=0;i<=twoIdx;i++) {
            while (i < twoIdx && nums[i] == 0) {
                nums[i] = nums[zeroIdx];
                nums[zeroIdx++] = 0;
            }
            while (i > zeroIdx && nums[i] == 2) {
                nums[i] = nums[twoIdx];
                nums[twoIdx--] = 2;
            }
        }
    }

    public static void main(String [ ] args) {
        int [] nums = new int [] {
                1,0,2,2,0,1,1,1,0,0,2
        };

        sortColors(nums);
        for (int i: nums) {
            System.out.println(i);
        }
    }
}
