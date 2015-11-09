public class UglyNumber {
    static public boolean isUgly(int num) {
        // 2,3,5

        if (num == 1) {
            return true;
        }

        if (num == 0) {
            return false;
        }

        if (num%2 == 0) {
            return isUgly(num/2);
        }

        if (num%3 == 0) {
            return isUgly(num/3);
        }

        if (num%5 == 0) {
            return isUgly(num/5);
        }

        return false;
    }

    public static void main(String [ ] args) {
        // false
        System.out.println(isUgly(14));

        // true
        System.out.println(isUgly(8));
    }
}
