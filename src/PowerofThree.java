public class PowerofThree {
    static public boolean isPowerOfThree(int n) {

        if (n < 1)
            return false;

        double logn3 = Math.log10(n)/Math.log10(3);

        return Math.floor(logn3) == logn3;
    }

    public static void main(String [ ] args) {
        System.out.println(isPowerOfThree(243));
    }
}
