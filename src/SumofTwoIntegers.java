public class SumofTwoIntegers {
    static public int getSum(int a, int b) {
        int res = 0;

        int carry = 0;
        for (int i=0;i<32;i++, a >>= 1, b >>= 1) {
            int ai = a&1;
            int bi = b&1;

            res |= (ai^bi^carry) << i;
            carry = (carry & ai) | (carry & bi) | (ai & bi);
        }

        return res;
    }

    public static void main(String [ ] args) {
        System.out.println(getSum(1,2));
    }
}
