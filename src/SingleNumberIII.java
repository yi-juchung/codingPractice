public class SingleNumberIII {
    static public int[] singleNumber(int[] nums) {
        int xor = 0;

        for (int i=0;i<nums.length;i++) {
            xor ^= nums[i];
        }

        int idx = 0;
        for (int i=0;i<32;i++) {
            if (((xor >> i) & 1) == 1) {
                idx = i;
                break;
            }
        }

        int xorGroup = 0;

        for (int i=0;i<nums.length;i++) {
            if (((nums[i] >> idx) & 1) == 1) {
                xorGroup ^= nums[i];
            }
        }

        int [] res = new int [] {xorGroup, xor^xorGroup};

        return res;
    }

    public static void main(String [ ] args) {
        int [] input = new int [] {1,2,1,3,2,5};

        for (int i : singleNumber(input)) {
            System.out.println(i);
        }
    }
}
