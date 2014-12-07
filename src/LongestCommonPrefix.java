public class LongestCommonPrefix {
    static public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1)
            return "";

        int curIdx = 0;

        while(true) {
            if (curIdx >= strs[0].length())
                break;

            boolean same = true;
            char firstChar = strs[0].charAt(curIdx);
            for (int i=1;i<strs.length;i++) {
                if (curIdx >= strs[i].length() || firstChar != strs[i].charAt(curIdx)) {
                    same = false;
                    break;
                }
            }

            if (same) {
                curIdx++;
            } else {
                break;
            }
        }

        return strs[0].substring(0,curIdx);
    }

    public static void main(String [ ] args) {
        String [] input = new String []{
                "aa",
                "a"
        };

        System.out.print(longestCommonPrefix(input));
    }
}
