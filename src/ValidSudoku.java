import java.util.Arrays;

public class ValidSudoku {
    static public boolean isValidSudoku(char[][] board) {

        boolean [] checkList = new boolean[9];

        for(int i = 0;i<9;i++) {
            Arrays.fill(checkList, Boolean.FALSE);
            for(int j = 0;j<9;j++) {
                if (board[i][j] != '.') {
                    if (checkList[board[i][j]-49]) {
                        return false;
                    } else {
                        checkList[board[i][j]-49] = true;
                    }
                }
            }
        }

        for(int i = 0;i<9;i++) {
            Arrays.fill(checkList, Boolean.FALSE);
            for(int j = 0;j<9;j++) {
                if (board[j][i] != '.') {
                    if (checkList[board[j][i]-49]) {
                        return false;
                    } else {
                        checkList[board[j][i]-49] = true;
                    }
                }
            }
        }

        for(int i = 0;i<9;i += 3) {
            for(int j = 0;j<9;j += 3) {
                Arrays.fill(checkList, Boolean.FALSE);
                for (int k = 0;k<3;k++) {
                    for (int l = 0;l<3;l++) {
                        if (board[i+k][j+l] != '.') {
                            if (checkList[board[i+k][j+l]-49]) {
                                return false;
                            } else {
                                checkList[board[i+k][j+l]-49] = true;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String [ ] args) {

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.print(isValidSudoku(board));
    }
}
