public class ExistSquareWith1 {
    public static boolean hasSquare(char [][] matrix) {

        for (int i=0;i<matrix.length-1;i++) {
            for (int j=0;j<matrix[0].length-1;j++) {

                if (matrix[i][j] == '1') {
                    for (int w=1;i+w<matrix.length && j+w<matrix[0].length;w++) {
                        if (checkSquare(matrix,i,j,w)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static boolean checkSquare(char [][] matrix, int i, int j, int width) {
        return matrix[i+width][j] == '1' && matrix[i][j+width] == '1' &&
                matrix[i+width][j+width] == '1';
    }

    public static void main(String [ ] args) {
        char [][] num = {
                {'0','1','0','1','0'},
                {'1','0','1','0','0'},
                {'0','1','0','1','0'},
                {'0','0','0','0','0'}};

        System.out.print(hasSquare(num));
    }
}
