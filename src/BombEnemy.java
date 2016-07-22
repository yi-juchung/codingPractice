public class BombEnemy {
    static public int maxKilledEnemies(char[][] grid) {
        int [] maxCol = new int [grid.length];
        int maxRow = 0;
        int maxKilled = 0;
        for (int j=0;j<grid[0].length;j++) {
            for (int i=0;i<grid.length;i++) {
                if (i == 0 || grid[i-1][j] == 'W') {
                    maxRow = 0;
                    for (int k=i;k<grid.length && grid[k][j] != 'W';k++) {
                        maxRow += grid[k][j] == 'E'?1:0;
                    }
                }

                if (j == 0 || grid[i][j-1] == 'W') {
                    maxCol[i] = 0;
                    for (int k=j;k<grid[i].length && grid[i][k] != 'W';k++) {
                        maxCol[i] += grid[i][k] == 'E'?1:0;
                    }
                }

                if (grid[i][j] == '0') {
                    maxKilled = Math.max(maxKilled, maxCol[i]+maxRow);
                }
            }
        }

        return maxKilled;

    }

    public static void main(String [ ] args) {
        char [][] grid = new char [][] {
                {'0','E','0','0'},
                {'E','0','W','E'},
                {'0','E','0','0'}
        };

        // 3
        System.out.println(maxKilledEnemies(grid));
    }
}
