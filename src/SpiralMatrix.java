import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    static public List<Integer> printSpiral(int[][] matrix) {
        List<Integer> res = new LinkedList<Integer>();

        if( matrix == null || matrix.length == 0 ) {
            return res;
        }

        //printSpiralRecur(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);



        return res;
    }

//    static public void printSpiralRecur(int [][]M,int sRow,int sCol,int eRow,int eCol) {
//
//        if (sRow>eRow||sCol>eCol) {
//            return;
//        }
//
//        if (sRow<eRow && sCol == eCol) {
//            for (int i=sRow;i<=eRow;i++) {
//                System.out.print(M[i][sCol]+" ");
//            }
//        }
//
//        for (int j=sCol;j<=eCol;j++) {
//            System.out.print(M[sRow][j]+" ");
//        }
//
//        if (sRow == eRow) {
//            return;
//        }
//
//        if (sCol<eCol) {
//            for (int i=sRow+1;i<eRow;i++) {
//                System.out.print(M[i][eCol]+" ");
//            }
//        }
//
//        if (sRow<eRow) {
//            for (int j=eCol;j>=sCol;j--) {
//                System.out.print(M[eRow][j]+" ");
//            }
//        }
//
//        if (sCol<eCol) {
//            for (int i=eRow-1;i>sRow;i--) {
//                System.out.print(M[i][sCol] + " ");
//            }
//        }
//
//        printSpiralRecur(M,sRow+1,sCol+1,eRow-1,eCol-1);
//    }

    public static void main(String [ ] args) {
//        int [][] mat = new int [][] {
//                {11, 12, 13, 14, 15},
//                {21, 22, 23, 24, 25},
//                {31, 32, 33, 34, 35},
//                {41, 42, 43, 44, 45}};

        int [][] mat = new int [][] {
                {1},{2},{3},{4},{5},{6},{7},{8},{9},{10}
        };

        printSpiral(mat);
    }
}
