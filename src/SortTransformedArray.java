public class SortTransformedArray {
    static public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int [] res = new int [nums.length];

        int i = 0;
        int j = nums.length-1;

        if (a > 0) {

        } else {

        }
    }

    public static void main(String [ ] args) {

        int [] nums = new int [] {-4, -2, 2, 4};

        for (int i: sortTransformedArray(nums,1,3,5)) {
            System.out.println(i);
        }

        System.out.println();
        nums = new int [] {-4, -2, 2, 4};

        for (int i: sortTransformedArray(nums,-1,3,5)) {
            System.out.println(i);
        }
    }
}
