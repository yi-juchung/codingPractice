public class MostOnes {

    public static int mostOnes(int [] input) {
        int [] dp = new int [input.length];

        int count = 0;
        for (int i=0;i<input.length;i++) {
            if (input[i] == 0) {
                count++;
            }

            dp[i] = count;
        }

        count = 0;
        int max = 0;
        for (int i=dp.length-1;i>=0;i--) {
            if (input[i] == 1) {
                count++;
            }

            if (dp[i]+count > max) {
                max = dp[i]+count;
            }
        }

        return max;
    }

    public static void main(String [ ] args) {
        int [] input = new int [] {0,0,1,0,1,1,0,1};

        System.out.println(mostOnes(input));
    }
}
