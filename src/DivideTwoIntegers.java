public class DivideTwoIntegers {
    static public int divide(int dividend, int divisor) {

        boolean nsign = (dividend<0) ^ (divisor<0);
        long d = (dividend < 0)?-(long)dividend:(long)dividend;
        long s = (divisor < 0)?-(long)divisor:(long)divisor;

        long res = 0;

        while (d >= s) {
            long t=s;
            int count = 0;

            while (t <= d) {
                d -= t;
                t <<= 1;
                res += 1<<count;
                count++;
            }
        }

        if (nsign) {
            if (res == Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return (int)-res;
            }
        } else {
            if (res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int)res;
            }
        }
    }

    public static void main(String [ ] args) {
        // -2147483648, -1

        System.out.println(divide(10,3));
    }
}
