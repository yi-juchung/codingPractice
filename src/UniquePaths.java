public class UniquePaths {
//    static public int uniquePaths(int m, int n) {
//        if (m > n) {
//            int t = m;
//            m = n;
//            n = t;
//        }
//
//        Double res = new Double(1);
//
//        for (int i=0;i<m-1;i++) {
//            res *= m+n-2-i;
//            res /= (i+1);
//        }
//
//        return res.intValue();
//    }

    static public int uniquePaths(int m, int n) {
        int dp[][] = new int [m+1][n+1];
        dp[1][1] = 1;
        for (int i=1;i<m+1;i++) {
            for (int j=1;j<n+1;j++) {
                dp[i][j] += dp[i][j-1]+dp[i-1][j];
            }
        }

        return dp[m][n];
    }



    public static void main(String [ ] args) {
        System.out.println(uniquePaths(51,9));
    }
}
