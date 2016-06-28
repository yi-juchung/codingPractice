public class IntegerBreak {
    static public int integerBreak(int n) {

//        if (n < 3) {
//            return (n==2)?1:0;
//        }
//
//        int [] fp = new int [n+1];
//        fp[1] = 1;
//        fp[2] = 2;
//        fp[3] = 2;
//
//        for (int i=4;i<n+1;i++) {
//            int max = 0;
//            for (int j=2;j<=4;j++) {
//                max = Math.max(Math.max(max,(i-j)*j), fp[i-j]*j);
//            }
//            fp[i] = max;
//        }
//
//        return fp[n];

        if (n == 2 || n == 3) return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

    public static void main(String [ ] args) {
        System.out.println(integerBreak(12));
    }
}
