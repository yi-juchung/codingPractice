import java.util.Stack;

public class SurroundedRegions {

    static public void solve(char[][] board) {
        if(board==null || board.length<=1 || board[0].length<=1)
            return;

        for(int i=0;i<board.length;i++) {
            fill(board,i,0,'#');
            fill(board,i,board[0].length-1,'#');
        }

        for(int i=0;i<board.length;i++) {
            fill(board,0,i,'#');
            fill(board,board.length-1,i,'#');
        }

        for(int i=1;i<board.length-1;i++) {
            for(int j=1;j<board[i].length-1;j++) {
                fill(board,i,j,'X');
            }
        }

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    static public void fill(char[][] board, int i, int j, char to) {
        if (i<0 || i >= board.length || j<0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        Stack<Integer> stack = new Stack<Integer>();
        stack.add(i*board[0].length+j);

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            int row = cur/board[0].length;
            int col = cur%board[0].length;
            board[row][col] = to;

            if (row>0 && board[row-1][col] == 'O') {
                stack.add((row-1)*board[0].length+col);
            }
            if (row<board.length-1 && board[row+1][col] == 'O') {
                stack.add((row+1)*board[0].length+col);
            }
            if (col>0 && board[row][col-1] == 'O') {
                stack.add(row*board[0].length+col-1);
            }
            if (col<board[0].length-1 && board[row][col+1] == 'O') {
                stack.add(row*board[0].length+col+1);
            }
        }
    }




//    static public void solve(char[][] board) {
//        for(int i=0;i<board.length;i++) {
//            for(int j=0;j<board[i].length;j++) {
//                if (board[i][j] != 'X' && board[i][j] != '#')
//                    recur(board,i,j);
//            }
//        }
//
//        for(int i=0;i<board.length;i++) {
//            for(int j=0;j<board[i].length;j++) {
//                if (board[i][j] == '#')
//                    board[i][j] = 'O';
//            }
//        }
//    }
//
//    static public boolean recur(char[][] board, int i, int j){
//        if (i<0 || i >= board.length || j<0 || j >= board[0].length || board[i][j] == '#') {
//            return false;
//        }
//        else if (board[i][j] == 'X' || board[i][j] == 'C') {
//            return true;
//        }
//        board[i][j] = 'C';
//        if (recur(board,i-1,j) && recur(board,i+1,j) && recur(board,i,j+1) && recur(board,i,j-1)) {
//            board[i][j] = 'X';
//            return true;
//        } else {
//            board[i][j] = '#';
//            return false;
//        }
//    }

    public static void main(String [] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'},
        };

        solve(board);

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board.length;j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
