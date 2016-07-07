public class SpiralMatrixII {

    static public int[][] generateMatrix(int n) {
        int [][] res = new int [n][n];

        helper(res, 0,n-1,1);

        return res;
    }

    static public void helper(int [][] m, int s, int e, int count) {
        if (s > e) {
            return;
        }

        for (int i=s;i<=e;i++) {
            m[s][i] = count++;
        }

        if (s == e)
            return;

        for (int i=s+1;i<=e;i++) {
            m[i][e] = count++;
        }

        for (int i=e-1;i>=s;i--) {
            m[e][i] = count++;
        }

        for (int i=e-1;i>s;i--) {
            m[i][s] = count++;
        }

        helper(m,s+1,e-1,count);
    }



    public static void main(String [ ] args) {

        int [][] mat = generateMatrix(3);

        for (int [] i : mat) {
            StringBuilder sb = new StringBuilder();
            for (int j : i) {
                sb.append(j+",");
            }
            System.out.println(sb);
        }
    }
}
