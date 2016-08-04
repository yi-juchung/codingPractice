public class OneEditDistance {
    static public boolean isOneEditDistance(String s, String t) {
        if (s.length() == t.length()) {
            return isOneDiff(s,t);
        } else if (Math.abs(s.length()-t.length()) == 1) {
            if (s.length() < t.length()) {
                String temp = s;
                s = t;
                t = temp;
            }
            return isOneRemoved(s,t);
        } else {
            return false;
        }
    }

    static public boolean isOneDiff(String s, String t) {
        boolean diff = false;

        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (diff) {
                    return false;
                } else {
                    diff = true;
                }
            }
        }

        return diff;
    }

    static public boolean isOneRemoved(String s, String t) {
        int i=0;
        int j=0;
        boolean diff = false;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                if (diff) {
                    return false;
                } else {
                    diff = true;
                    i++;
                }
            } else {
                i++;
                j++;
            }
        }

        return diff || i < s.length();
    }

    public static void main(String [ ] args) {
        System.out.println(isOneEditDistance("abc","abd"));

        System.out.println(isOneEditDistance("abc","abce"));

        System.out.println(isOneEditDistance("abc","ab"));

        System.out.println(isOneEditDistance("abcd","abdd"));

        System.out.println(isOneEditDistance("abcd","cbdd"));

        System.out.println(isOneEditDistance("abc","ad"));
    }
}
