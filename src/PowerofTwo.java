public class PowerofTwo {
    static public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;

        if (n == 1)
            return true;

        return (n%2 == 0) && isPowerOfTwo(n/2);
    }

    public static void main(String [ ] args) {
        // false
        System.out.println(isPowerOfTwo(14));

        // true
        System.out.println(isPowerOfTwo(8));
    }
}
