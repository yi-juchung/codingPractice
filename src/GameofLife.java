public class GameofLife {
    // live to dead : 3
    // dead to live : 2
    // live to live : 1
    // dead to dead : 0
    static public void gameOfLife(int[][] board) {
        int [] di = {-1, -1, -1,  0, 0,  1, 1, 1};
        int [] dj = {-1,  0,  1, -1, 1, -1, 0, 1};

        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[i].length;j++) {
                int live = 0;

                for (int k =0;k<8;k++) {
                    int ii = i + di[k], jj = j + dj[k];
                    if (ii < 0 || ii >= board.length || jj < 0 || jj >= board[0].length) continue;
                    if (board[ii][jj]%2==1) live++;
                }

                if (board[i][j] == 1 && (live < 2 || live > 3)) board[i][j] = 3;
                else if (board[i][j] == 0 && live == 3) board[i][j] = 2;
            }
        }

        for (int i=0;i<board.length;i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }


    public static void main(String [ ] args) {
        int [][] board = {
                {1,1,0,0,0,0},
                {1,0,0,1,1,0},
                {0,0,1,1,1,1},
                {0,1,0,1,1,0},
                {1,0,0,0,1,1}
        };

        gameOfLife(board);

        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                System.out.print(board[i][j]+",");
            }
            System.out.println();
        }
    }
}
