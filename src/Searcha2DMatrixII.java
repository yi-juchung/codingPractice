public class Searcha2DMatrixII {
    static public boolean searchMatrix(int[][] matrix, int target) {
        return helper(matrix, target, 0, matrix.length-1, 0, matrix[0].length-1);
    }

    static public boolean helper(int [][] m, int target, int sx, int ex, int sy, int ey) {

        if (sx > ex || sy > ey) {
            return false;
        }

        int mx = sx+(ex-sx)/2;
        int my = sy+(ey-sy)/2;

        if (m[mx][my] == target) {
            return true;
        } else if (m[mx][my] > target) {
            return helper(m, target, sx, mx-1, sy, my-1) || helper(m, target, mx, ex, sy, my-1) ||
                    helper(m, target, sx, mx-1, sy, ey);
        } else {
            return helper(m, target, mx+1, ex, my+1, ey) || helper(m, target, mx+1, ex, sy, ey) ||
                    helper(m, target, sx, ex, my+1, ey);
        }
    }

    public static void main(String [ ] args) {
        int [][] m = new int [][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(searchMatrix(m,5));
        System.out.println(searchMatrix(m,20));
    }
}
