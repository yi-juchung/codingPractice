public class isPalindrome {

    static public boolean isAlphanumeric(Character c) {
        return Character.isDigit(c) || (c <123 && c > 96);
    }

    static public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        s = s.toLowerCase();
        int len = s.length();
        int i = 0;
        int j = s.length()-1;

        boolean res = true;

        do {
            while (i < len-1 && !isAlphanumeric(s.charAt(i))) {
                i++;
            }

            while (j > 0 && !isAlphanumeric(s.charAt(j))) {
                j--;
            }

            if (i < j && s.charAt(i) != s.charAt(j)) {
                res = false;
                break;
            }
            i++;
            j--;
        } while (i < j);

        return res;
    }

    public static void main(String [ ] args) {
        System.out.println(isPalindrome("1a2"));
        System.out.println(isPalindrome("race a car"));
    }
}
