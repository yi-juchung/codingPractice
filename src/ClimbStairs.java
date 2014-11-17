public class ClimbStairs {
    static public int climbStairs(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;

        int [] num = new int [n];
        num[0] = 1;
        num[1] = 2;

        for (int i=2;i<n;i++) {
            num[i] = num[i-1]+num[i-2];
        }

        return num[n-1];
    }

    public static void main(String [ ] args) {
        System.out.print(climbStairs(38));
    }
}
