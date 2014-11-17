public class PlusOne {
    static public int[] plusOne(int[] digits) {
        int carry = 1;

        for (int i = digits.length-1;i >= 0;i--) {
            digits[i] += carry;

            carry = digits[i]/10;
            digits[i] = digits[i]%10;
        }

        if (carry > 0) {
            int [] res = new int [digits.length+1];
            res[0] = carry;
            for(int i=1;i<res.length;i++) {
                res[i] = digits[i-1];
            }

            digits = res;
        }

        return digits;
    }

    public static void main(String [ ] args) {
        int [] num = {9,8};
        num = plusOne(num);
        for(int i : num) {
            System.out.print(i);
        }
    }
}
