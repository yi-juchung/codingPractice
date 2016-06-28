public class PalindromePermutation {

    public static boolean isPalin(String s) {
        boolean [] chars = new boolean[26];

        for (char c : s.toCharArray()) {
            chars[c-'a'] ^= true;
        }

        int i = 0;

        for (boolean b : chars) {
            if (b) {
                i++;
            }
        }

        return (s.length()%2 == 0)?i==0:i==1;
    }

    public static void main(String [ ] args) {
        String s = "code";

        System.out.println(isPalin(s));
        s = "aab";
        System.out.println(isPalin(s));
        s = "carerac";
        System.out.println(isPalin(s));
    }
}
