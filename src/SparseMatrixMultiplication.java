import java.util.HashMap;
import java.util.Map;

public class SparseMatrixMultiplication {
    public static int[][] multiply(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0)
            return new int [0][0];

        int [][] C = new int [A.length][B[0].length];

        Map<Integer,Map<Integer,Integer>> AMap = new HashMap<>();
        for (int i=0;i<A.length;i++) {
            for (int j=0;j<A[0].length;j++) {
                if (A[i][j] != 0) {
                    Map<Integer,Integer> innerMap;
                    if (AMap.containsKey(i)) {
                        innerMap = AMap.get(i);
                    } else {
                        innerMap = new HashMap<>();
                    }
                    innerMap.put(j,A[i][j]);
                    AMap.put(i,innerMap);
                }
            }
        }

        Map<Integer,Map<Integer,Integer>> BMap = new HashMap<>();
        for (int i=0;i<B.length;i++) {
            for (int j=0;j<B[0].length;j++) {
                if (B[i][j] != 0) {
                    Map<Integer,Integer> innerMap;
                    if (BMap.containsKey(i)) {
                        innerMap = BMap.get(i);
                    } else {
                        innerMap = new HashMap<>();
                    }
                    innerMap.put(j,B[i][j]);
                    BMap.put(i,innerMap);
                }
            }
        }

        for (int i : AMap.keySet()) {
            for (int j : AMap.get(i).keySet()) {
                if (BMap.containsKey(j)) {
                    for (int k : BMap.get(j).keySet()) {
                        C[i][k] += AMap.get(i).get(j)*BMap.get(j).get(k);
                    }
                }
            }
        }

        return C;
    }

    public static void main(String [ ] args) {
        int [][] A = new int [][] {
            {1,0,0},
            {-1,0,3}
        };

        int [][] B = new int [][] {
                {7,0,0},
                {0,0,0},
                {0,0,1}
        };

        int [][] C = multiply(A,B);

        for (int i=0;i<C.length;i++) {
            for (int j=0;j<C[0].length;j++) {
                System.out.print(C[i][j]);
            }

            System.out.println();
        }
    }
}
