public class TrappingRainWater {
    static public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int [] left = new int [height.length];

        int cur = height[0];
        left[0] = cur;
        for (int i=1;i<height.length;i++) {
            if (height[i] > cur) {
                cur = height[i];
            }
            left[i] = cur;
        }

        cur = height[height.length-1];
        left[height.length-1] = Math.min(cur,left[height.length-1]);
        for (int i=height.length-2;i>=0;i--) {
            if (height[i] > cur) {
                cur = height[i];
            }
            left[i] = Math.min(cur,left[i]);
        }

        int res = 0;

        for (int i=0;i<height.length;i++) {
            res += (left[i]-height[i]);
        }

        return res;
    }

    public static void main(String [] argv) {
        int [] input = new int [] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(input));
    }
}
