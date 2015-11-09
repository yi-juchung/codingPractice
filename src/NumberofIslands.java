import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands {
    static public int numIslands(char[][] grid) {
        boolean [][] checked = new boolean[grid.length][grid[0].length];

        int count = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == '1' && !checked[i][j]) {
                    count++;
                    fillIterative(grid, i, j, checked);
                }
            }
        }

        return count;
    }

    static public void fillIterative(char [][] grid, int i, int j, boolean [][] checked) {
        Queue<Pair<Integer,Integer>> next = new LinkedList<Pair<Integer, Integer>>();

        next.add(new Pair<Integer, Integer>(i,j));

        while (!next.isEmpty()) {
            Pair<Integer,Integer> cur = next.poll();
            int curI = cur.getKey();
            int curJ = cur.getValue();

            if (checked[curI][curJ]) {
                continue;
            }

            checked[curI][curJ] = true;

            if (grid[curI][curJ] == '1') {
                if (curI > 0) {
                    next.add(new Pair<Integer, Integer>(curI-1,curJ));
                }
                if (curJ > 0) {
                    next.add(new Pair<Integer, Integer>(curI,curJ-1));
                }
                if (curI < grid.length-1) {
                    next.add(new Pair<Integer, Integer>(curI+1,curJ));
                }
                if (curJ < grid[0].length-1) {
                    next.add(new Pair<Integer, Integer>(curI,curJ+1));
                }
            }
        }
    }

    static public void fill(char[][] grid, int i, int j, boolean[][] checked) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || checked[i][j]) {
            return;
        }

        if (grid[i][j] == '0') {
            checked[i][j] = true;
            return;
        }

        grid[i][j] = '0';
        checked[i][j] = true;

        fill(grid, i+1, j, checked);
        fill(grid, i, j+1, checked);
        fill(grid, i-1, j, checked);
        fill(grid, i, j-1, checked);
    }

    public static void main(String [] args) {
        char[][] board = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        };

        System.out.print(numIslands(board));

//        for(int i=0;i<board.length;i++) {
//            for(int j=0;j<board.length;j++) {
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }
    }
}
