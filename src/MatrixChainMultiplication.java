import java.util.Arrays;

public class MatrixChainMultiplication {
    public static int minMulti(int [] input) {
        if (input == null || input.length < 0)
            return 0;

        int [][] mem = new int[input.length][input.length];

        for (int i=0;i<input.length;i++) {
            Arrays.fill(mem[i], -1);
        }

        for (int i=1;i<input.length;i++) {
            mem[1][i] = min(mem,input,1,i);
        }

        return mem[1][input.length-1];
    }

    public static int min(int [][] mem, int [] input, int i, int j) {
        if (i == j){
            mem[i][j] = 0;
        } else if (mem[i][j] == -1) {
            mem[i][j] = Integer.MAX_VALUE;

            for (int k=i;k<j;k++) {
                int cost = min(mem, input, i, k)+min(mem, input, k+1, j)+input[i-1]*input[k]*input[j];

                if (cost < mem[i][j]) {
                    mem[i][j] = cost;
                }
            }
        }

        return mem[i][j];
    }

    public static void main(String [ ] args) {

        // 26000
//        int [] input = new int[]{40, 20, 30, 10, 30};

//        // 30000
        int [] input = new int[]{10, 20, 30, 40, 30};
//
//        // 6000
//        int [] input = new int[]{10, 20, 30};

        System.out.println(minMulti(input));
    }
}
