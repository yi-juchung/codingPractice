public class MinimumPathSum {
    static public int minPathSum(int[][] grid) {
        int [][] dp = new int [grid.length+1][grid[0].length+1];

        for (int i=0;i<dp.length;i++) {
            for (int j=0;j<dp[0].length;j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i=1;i<dp.length;i++) {
            for (int j=1;j<dp[0].length;j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = grid[0][0];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i-1][j-1];
                }
            }
        }

        return dp[grid.length][grid[0].length];
    }

    public static void main(String [ ] args) {
//        int [][] mat = new int [][] {
//                {131,673,234,103,18},
//                {201,96,342,965,150},
//                {630,803,746,422,111},
//                {537,699,497,121,956},
//                {805,732,524,37,331}
//        };
//
//        // 2427
//        System.out.println(minPathSum(mat));
//
//        mat = new int [][] {
//                {1,2},
//                {5,6},
//                {1,1}
//        };
//
//        System.out.println(minPathSum(mat));

        int [][]mat = new int [][] {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        System.out.println(minPathSum(mat));
    }
}
