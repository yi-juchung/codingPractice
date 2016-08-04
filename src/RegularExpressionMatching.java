public class RegularExpressionMatching {
    static public boolean isMatch(String s, String p) {
        return helper(s,p);
    }

    static public boolean helper(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        if (p.length() > 1 && p.charAt(1) == '*') {
            return (s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && helper(s.substring(1),p)) || helper(s, p.substring(2));
        } else {
            return s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && helper(s.substring(1), p.substring(1));
        }
    }

    public static void main(String [ ] args) {

        // F
        System.out.println(isMatch("aa","a"));

        // T
        System.out.println(isMatch("aa","aa"));

        // F
        System.out.println(isMatch("aaa","aa"));

        // T
        System.out.println(isMatch("aa","a*"));

        // T
        System.out.println(isMatch("aa",".*"));

        // T
        System.out.println(isMatch("aab","c*a*b"));
    }
}
