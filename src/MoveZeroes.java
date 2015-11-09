public class MoveZeroes {
    static public void moveZeroes(int[] nums) {
        for (int notZero=-1, idx=0;idx<nums.length;idx++) {
            if (nums[idx] != 0) {
                nums[++notZero] = nums[idx];
                if (notZero != idx) nums[idx] = 0;
            }
        }
    }

    public static void main(String [ ] args) {
        int [] input = new int [] {0, 1, 0, 3, 12};
        moveZeroes(input);

        for (int i : input) {
            System.out.println(i);
        }
    }
}
