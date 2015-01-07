public class ExcelSheetColumnNumber {
    static public int titleToNumber(String s) {
        char [] chars = s.toCharArray();
        long res = 0;
        boolean overflow = false;
        for (char c : chars) {
            res += c-64;

            if (res*26 > Integer.MAX_VALUE) {
                overflow = true;
            } else {
                res *= 26;
            }
        }

        return (overflow)?(int)res:(int)res/26;
    }

    public static void main(String [ ] args) {
        System.out.print(titleToNumber("CFDGSXM"));
    }
}
