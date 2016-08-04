public class JumpGame {
    static public boolean canJump(int[] nums) {
        boolean [] able = new boolean[nums.length+1];
        able[1] = true;

        for (int i=2;i<able.length;i++) {
            for (int j=i-1;j>=1;j--) {
                if (able[j] && nums[j-1] >= i-j) {
                    able[i] = true;
                    break;
                }
            }
        }

        return able[nums.length];
    }

    public static void main(String [ ] args) {
        int [] res = new int [] {2,3,1,1,4};

        // true
        System.out.println(canJump(res));

        res = new int [] {3,2,1,0,4};

        // false
        System.out.println(canJump(res));
    }
}
