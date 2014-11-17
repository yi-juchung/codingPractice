import java.util.Arrays;

public class ThreeSumClosest {
    static public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);

        int closest = Integer.MAX_VALUE;
        int minDiffAbs = Integer.MAX_VALUE;
        for (int i = 0;i<num.length-2;i++) {
            int j = i+1;
            int k = num.length-1;

            while (j < k) {
                int cur = num[i]+num[j]+num[k];
                int curDiff = cur-target;
                int abs = Math.abs(curDiff);

                if (abs < minDiffAbs) {
                    minDiffAbs = abs;
                    closest = cur;
                }

                if (curDiff < 0)
                    j++;
                else
                    k--;
            }
        }

        return closest;
    }

    public static void main(String [ ] args) {
        int [] num = {1,2,4,8,16,32,64,128};
        System.out.print(threeSumClosest(num,82));
    }
}
