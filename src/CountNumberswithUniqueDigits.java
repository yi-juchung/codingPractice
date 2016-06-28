public class CountNumberswithUniqueDigits {
    static public int countNumbersWithUniqueDigits(int n) {
        if (n < 1)
            return 1;
        else if (n == 1)
            return 10;
//        int [] PK = new int [(n>10)?11:n+1];
//        PK[1] = 10;
//
//        for (int i=2;i<n+1;i++) {
//            int multi = 9;
//
//            for (int j=9;j>=11-i;j--) {
//                multi *= j;
//            }
//
//            PK[i] = multi;
//        }
//
//        int sum = 0;
//
//        for (int i=0;i<n+1;i++) {
//            sum += PK[i];
//        }

        int sum = 10;
        int cnt = 9;

        for (int i=2;i<n+1;i++) {
            cnt *= (11-i);
            sum += cnt;
        }

        return sum;
    }

    public static void main(String [ ] args) {
        System.out.println(countNumbersWithUniqueDigits(2));
    }
}
