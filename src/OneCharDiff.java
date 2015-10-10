
public class OneCharDiff {

    static public boolean isOneCharDiff(String left, String right) {
        if (Math.abs(left.length()-right.length()) > 1) {
            return false;
        }

        boolean diff = false;

        if (left.length() > right.length()) {
            String temp = left;
            left = right;
            right = temp;
        }

        int i=0;
        for (;i<left.length();i++) {
            char cl = left.charAt(i);
            char cr = right.charAt(i);

            if (cl != cr) {
                if (diff) {
                    return false;
                } else {
                    diff = true;
                }
            }
        }

        if (i<right.length() && diff) {
            return false;
        }

        return true;
    }

    public static void main(String [ ] args) {

        System.out.print(isOneCharDiff("xyz", "x"));
    }
}
