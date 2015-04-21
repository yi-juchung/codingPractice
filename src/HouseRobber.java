public class HouseRobber {
    static public int rob(int[] num) {
        int [] picked = new int [num.length];

        for (int i=0;i<num.length;i++) {
            if (i == 0) {
                picked[i] = num[i];
            } else if (i == 1) {
                picked[i] = Math.max(num[i],num[i-1]);
            } else {
                picked[i] = Math.max(num[i]+picked[i-2],picked[i-1]);
            }
        }

        return (num.length > 0)?picked[num.length-1]:0;
    }

    public static void main(String [ ] args) {
        int [] value = {1,1,1};

        System.out.print(rob(value));
    }
}
