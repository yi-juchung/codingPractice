public class CountBlocks {

    static int countBlocks(int [][] board) {
        int res = 0;
        boolean [][] visited = new boolean [board.length][board[0].length];
        for (int i=0;i<board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    int count = DFS(board, visited, i, j, 0);

                    if (count > 1)
                        res++;
                }
            }
        }

        return res;
    }

    static int DFS(int [][] board, boolean [][] visited, int i, int j, int count) {
        if (i < 0 || i == board.length) return count;
        if (j < 0 || j == board[0].length) return count;
        if (visited[i][j] || board[i][j] == 0) return count;

        count++;
        visited[i][j] = true;

        int tempCount = DFS(board,visited,i+1,j,0);
        tempCount += DFS(board,visited,i,j+1,0);
        tempCount += DFS(board,visited,i-1,j,0);
        tempCount += DFS(board,visited,i,j-1,0);

        return count+tempCount;
    }

    public static void main(String [ ] args) {

        // 3
        int [][] board = new int[][]{
                {1,1,0,1,0,0},
                {0,0,0,0,0,1},
                {1,0,1,0,1,1},
                {1,0,0,0,0,0}
        };

        System.out.print(countBlocks(board));
    }
}
