public class WordSearch {
    static public boolean exist(char[][] board, String word) {
        boolean res = false;

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                res = search(visited,board,i,j,0,word);

                if (res)
                    return res;
            }
        }

        return res;
    }

    static public boolean search(boolean[][] visited, char[][] board, int x, int y, int cur, String word) {
        if (x < 0 || x > board.length-1 || y < 0 || y > board[0].length-1) {
            return false;
        }

        boolean checked = false;
        if (board[x][y] == word.charAt(cur) && !visited[x][y]) {
            if (cur == word.length()-1) {
                checked = true;
            } else {
                visited[x][y] = true;
                checked = search(visited, board, x+1,y,cur+1,word) ||
                        search(visited, board, x,y+1,cur+1,word) ||
                        search(visited, board, x-1,y,cur+1,word) ||
                        search(visited, board, x,y-1,cur+1,word);

                if (!checked)
                    visited[x][y] = false;
            }
        }

        return checked;
    }

    public static void main(String [ ] args) {

        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.print(exist(board, "ABCCED"));
    }
}
