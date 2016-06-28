public class ReverseVowelsofaString {

    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        } else {
            return false;
        }
    }

    public static String rev(String s) {
        char [] chars = s.toCharArray();

        int i=0;
        int j=chars.length-1;

        while (i<j) {
            while (i<j && !isVowel(chars[i])) {
                i++;
            }
            while (i<j && !isVowel(chars[j])) {
                j--;
            }

            if (i>=j)
                break;

            char c2 = chars[i];
            chars[i] = chars[j];
            chars[j] = c2;

            i++; j--;
        }

        return new String(chars);
    }

    public static void main(String [ ] args) {
        System.out.println(rev("hello"));

    }
}
