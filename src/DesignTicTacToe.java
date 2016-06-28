public class DesignTicTacToe {

    static public class TicTacToe {
        int [][] board;
        int [] hor;
        int [] ver;
        int [] cross;

        public TicTacToe(int w) {
            cross = new int [2];
            hor = new int [w];
            ver = new int [w];
        }

        public int move(int i, int j, int v) {

            int indict = (v==1)?-1:1;
            hor[i] += indict;
            ver[j] += indict;

            if (i+j == hor.length) {
                cross[0] += indict;
            }

            if (i-j == 0) {
                cross[1] += indict;
            }

            if (isWin(i,j,v)) {
                return v;
            } else {
                return 0;
            }
        }

        public boolean isWin (int i, int j, int v) {
            boolean w = false;
            int indict = (v==1)?-hor.length:hor.length;
            w = hor[i] == indict || ver[j] == indict;

            if (!w && (i+j == hor.length || i-j == 0)) {
                w = cross[0] == indict || cross[1] == indict;
            }

            return w;
        }

    }

    public static void main(String [ ] args) {
        TicTacToe toe = new TicTacToe(3);

        System.out.println(toe.move(0, 0, 1));
        System.out.println(toe.move(0, 2, 2));
        System.out.println(toe.move(2, 2, 1));
        System.out.println(toe.move(1, 1, 2));
        System.out.println(toe.move(2, 0, 1));
        System.out.println(toe.move(1, 0, 2));
        System.out.println(toe.move(2, 1, 1));
    }
}
