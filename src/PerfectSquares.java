public class PerfectSquares {
//    static public int numSquares(int n) {
//        int [] sq = new int[n+1];
//        sq[0] = 0;
//
//        for (int i=1;i<sq.length;i++) {
//            if (isSquare(i)) {
//                sq[i] = 1;
//                continue;
//            }
//
//            int small = Integer.MAX_VALUE;
//
//            for (int j=i-1;j>=0;j--) {
//                if (sq[j] == 1) {
//                    small = Math.min(small, sq[i-j]+1);
//                }
//            }
//
//            sq[i] = small;
//        }
//
//        return sq[n];
//    }
//
//    static public boolean isSquare (int n) {
//        int r = (int)Math.sqrt(n);
//        return r*r == n;
//    }

    static public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;
            for (int j = 1;j*j <= i;j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        return dp[n];
    }

    public static void main(String [ ] args) {
        System.out.println(numSquares(13));
    }
}
