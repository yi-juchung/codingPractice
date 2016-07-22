public class Searcha2DMatrix {
    static public boolean searchMatrix(int[][] matrix, int target) {
        int sRow = 0;
        int eRow = matrix.length-1;

        int row = -1;
        while (sRow <= eRow && sRow >= 0 && eRow <= matrix.length-1) {
            int mRow = sRow + (eRow-sRow)/2;

            if (matrix[mRow][0] <= target && matrix[mRow][matrix[0].length-1] >= target) {
                row = mRow;
                break;
            } else if (matrix[mRow][0] > target) {
                eRow = mRow-1;
            } else {
                sRow = mRow+1;
            }
        }

        if (row != -1) {

            int sCol = 0;
            int eCol = matrix[0].length-1;

            while (sCol <= eCol && sCol >= 0 && eCol <= matrix[0].length-1) {
                int mCol = sCol + (eCol-sCol)/2;

                if (matrix[row][mCol] == target) {
                    return true;
                } else if (matrix[row][mCol] > target) {
                    eCol = mCol-1;
                } else {
                    sCol = mCol+1;
                }
            }

            return false;

        } else {
            return false;
        }
    }

    public static void main(String [ ] args) {
        int [][] m = new int [][] {
                {1}
        };

        System.out.println(searchMatrix(m,1));
    }
}
