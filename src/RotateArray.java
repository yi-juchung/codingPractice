public class RotateArray {
    static public void rotate(int[] nums, int k) {
        if (nums.length < 2 || nums.length==k || k==0) {
            return;
        }
        int done = 0;
        int idx = 0;
        int startIdx = 0;
        k = (nums.length>k)?nums.length-k:(nums.length-(k%nums.length));
        int prev = nums[startIdx];
        while (done != nums.length) {
            int nxt = (idx+k)%nums.length;

            if (nxt == startIdx) {
                if (done+1 != nums.length) {
                    nums[idx] = prev;
                    startIdx++;
                    idx = startIdx;
                    nxt = idx;
                    prev = nums[idx];
                } else {
                    nums[idx] = prev;
                }
            } else {
                nums[idx] = nums[nxt];
            }
            idx = nxt;
            done++;
        }
    }

    static public void rotateV2(int[] nums, int k) {
        if (nums.length == 0) return;
        int n = nums.length;
        while ((k %= n) > 0 && n > 1) {
            int range = n - k;
            for (int i = 1; i <= range; i++) {
                int val = nums[n - i];
                nums[n - i] = nums[n - i - k];
                nums[n - i - k] = val;
            }
            n = k;
            k = n - (range % k);
        }
    }

    public static void main(String [ ] args) {

        int [] num = new int[]{1,2,3,4,5,6};
        rotate(num, 4);

        for (int v : num) {
            System.out.print(v+" ");
        }
    }
}
