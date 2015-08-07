public class MaximalSquare {
    static public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return 0;
        }

        int curMax = 0;
        for(int i=0; i < matrix.length; i++) {
            for (int j=0;j<matrix[0].length;j++) {
                if (matrix[i][j] == '1' && i > 0 && j > 0) {
                    matrix[i][j] = (char)Math.min((int)matrix[i][j-1],(int)matrix[i-1][j]);
                    matrix[i][j] = (char)(Math.min((int)matrix[i][j],(int)matrix[i-1][j-1])+1);
                }

                if (matrix[i][j]-'0' > curMax) {
                    curMax = matrix[i][j]-'0';
                }
            }
        }

        return curMax*curMax;
    }

    public static void main(String [ ] args) {
        char [][] num = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};

        System.out.print(maximalSquare(num));
    }
}
