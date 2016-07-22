public class SetMatrixZeroes {
    static public void setZeroes(int[][] matrix) {
        int row = -1;
        int col = -1;

        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                if (matrix[i][j] == 0) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        if (row == -1 && col == -1)
            return;

        for (int i=0;i<matrix.length;i++) {
            if (i == row)
                continue;
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == col)
                    continue;
                if (matrix[i][j] == 0) {
                    matrix[row][j] = 0;
                    matrix[i][col] = 0;
                }
            }
        }

        for (int i=0;i<matrix[row].length;i++) {
            if (i == col)
                continue;
            if (matrix[row][i] == 0) {
                for (int j=0;j<matrix.length;j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i=0;i<matrix.length;i++) {
            if (matrix[i][col] == 0) {
                for (int j=0;j<matrix[i].length;j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i=0;i<matrix[row].length;i++) {
            matrix[row][i] = 0;
        }

        for (int i=0;i<matrix.length;i++) {
            matrix[i][col] = 0;
        }
    }

    public static void main(String [ ] args) {
        int [][] m = new int [][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 0, 19},
                {3,   0,  9, 16, 22},
                {10, 13, 0, 17, 24},
                {18, 21, 23, 26, 2}
        };

        for (int [] i: m) {
            for (int j : i) {
                System.out.print(j+",");
            }

            System.out.println();
        }

        setZeroes(m);

        for (int [] i: m) {
            for (int j : i) {
                System.out.print(j+",");
            }

            System.out.println();
        }
    }
}
