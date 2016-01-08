import java.util.HashSet;

public class RemoveDuplicatesChars {

    static String removeDuplicates(String s) {
        char [] chars = s.toCharArray();

        int i = 0;
        int j = s.length()-1;

        HashSet<Character> set = new HashSet<Character>();

        while (i<j) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                i++;
            } else {
                char temp = chars[j];
                chars[j] = chars[i];
                chars[i] = temp;
                j--;
            }
        }

        return new String(chars,0,i+1);
    }

    public static void main(String [ ] args) {

        String s = "abacb";

        System.out.print(removeDuplicates(s));
    }
}
