import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    static public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new LinkedList<List<String>>();

        boolean [][] grid = new boolean[n][n];

        solve(grid, 0, res);

        return res;
    }

    static public boolean isSafe(boolean [][] grid, int row, int col) {
        for (int i=row, j=col;i>=0 && j>=0;i--, j--) {
            if (grid[i][j])
                return false;
        }

        for (int i=col;i>=0;i--) {
            if (grid[row][i])
                return false;
        }

        for (int i=row, j=col;i<grid.length && j>=0;i++, j--) {
            if (grid[i][j])
                return false;
        }

        return true;
    }

    static public void solve(boolean [][] grid, int col, List<List<String>> res) {
        if (col == grid.length) {
            res.add(printBoard(grid));
            return;
        }

        for (int i = 0;i < grid.length;i++) {
            if (isSafe(grid, i, col)) {
                grid[i][col] = true;
                solve(grid, col+1, res);
                grid[i][col] = false;
            }
        }
    }

    static public List<String> printBoard(boolean [][] grid) {
        List<String> res = new LinkedList<String>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<grid.length;i++) {
            for (int j=0;j<grid.length;j++) {
                sb.append(grid[i][j]?'Q':'.');
            }
            res.add(sb.toString());
            sb = new StringBuilder();
        }

        return res;
    }

    public static void main(String [ ] args) {
        System.out.println(solveNQueens(4));
    }
}
