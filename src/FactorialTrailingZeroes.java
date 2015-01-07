public class FactorialTrailingZeroes {
    public static int trailingZeroes(int n) {
        int res = n/5;

        if (res == 0)
            return 0;
        else {
            return res+trailingZeroes(res);
        }
    }

    public static void main(String [ ] args) {
        System.out.print(trailingZeroes(10));
    }
}
