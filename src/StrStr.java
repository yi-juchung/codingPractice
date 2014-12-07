public class StrStr {
    static public int strStr(String haystack, String needle) {

        if (haystack.length() < needle.length())
            return -1;

        if (haystack.length() == 0)
            return 0;

        for (int i=0;i<haystack.length()-needle.length()+1;i++) {
            if (helper(i,haystack,needle)) {
                return i;
            }
        }

        return -1;
    }

    static public boolean helper(int idx, String haystack, String needle) {
        if (haystack.length()-idx < needle.length())
            return false;

        for(int i=0;i<needle.length();i++) {
            if (haystack.charAt(idx+i) != needle.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String [ ] args) {
        System.out.print(strStr("a","a"));
    }
}
