public class ExcelSheetColumnTitle {

    static public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            int mod = n%26;
            if (mod == 0)
                mod = 26;
            n = (n-mod)/26;

            sb.insert(0,(char) (mod+64));
        }

        return sb.toString();
    }

    public static void main(String [ ] args) {
        System.out.print(convertToTitle(26));
    }
}
