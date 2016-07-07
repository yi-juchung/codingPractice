public class ValidPerfectSquare {
//    static public boolean isPerfectSquare(int num) {
//
//        if (num == 1)
//            return true;
//
//        for (int i=2;i<=num/2;i++) {
//            if (i*i == num) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    static public boolean isPerfectSquare(int num) {

        int i = 1;

        while (i*i < num) {
            i += 2*i+1;

            if (i*i == num)
                return true;
        }

        return false;
    }

    public static void main(String [ ] args) {
        System.out.println(isPerfectSquare(16));

        System.out.println(isPerfectSquare(14));
    }
}
