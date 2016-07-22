public class RotateImage {
    static public void rotate(int[][] matrix) {
        helper(matrix, 0, matrix.length-1);
    }

    static public void helper (int [][] m, int s, int e)  {
        if (s >= e) {
            return;
        }

        for (int i=0;i<e-s;i++) {
            int temp = m[s+i][s];

            m[s+i][s] = m[e][s+i];
            m[e][s+i] = m[e-i][e];
            m[e-i][e] = m[s][e-i];
            m[s][e-i] = temp;
        }

        helper(m, s+1, e-1);
    }

    public static void main(String [ ] args) {
        int [][] m = new int [][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        for (int [] i: m) {
            for (int j : i) {
                System.out.print(j+",");
            }

            System.out.println();
        }

        rotate(m);

        for (int [] i: m) {
            for (int j : i) {
                System.out.print(j+",");
            }

            System.out.println();
        }
    }
}
