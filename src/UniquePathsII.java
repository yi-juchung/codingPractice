public class UniquePathsII {
    static public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int [][] dp = new int [obstacleGrid.length+1][obstacleGrid[0].length+1];

        dp[1][1] = (obstacleGrid[0][0] == 0)?1:0;
        for (int i=1;i<dp.length;i++) {
            for (int j=1;j<dp[0].length;j++) {
                if (obstacleGrid[i-1][j-1] == 0) {
                    dp[i][j] += dp[i-1][j]+dp[i][j-1];
                }
            }
        }

        return dp[obstacleGrid.length][obstacleGrid[0].length];
    }

    public static void main(String [ ] args) {
        int [][] m = new int [][] {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        System.out.println(uniquePathsWithObstacles(m));
    }
}
