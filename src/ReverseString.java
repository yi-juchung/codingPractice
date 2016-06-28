public class ReverseString {
    static public String reverseString(String s) {
        char [] chars = s.toCharArray();

        int i=0;
        int j=s.length()-1;

        while (i<j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++; j--;
        }

        return new String(chars);
    }

    public static void main(String [ ] args) {
        System.out.println(reverseString("hello"));
    }
}
