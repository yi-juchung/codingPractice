public class LengthOfLastWord {
    static public int lengthOfLastWord(String s) {
        if (s == null || s.length() < 1)
            return 0;

        int beginWord = -1;
        int endWord = 0;
        int curIdx = 0;

        boolean word = false;
        while (curIdx < s.length()) {
            if (word) {
                if (s.charAt(curIdx) == ' ') {
                    endWord = curIdx;
                    word = !word;
                }
            } else {
                if (s.charAt(curIdx) != ' ') {
                    beginWord = curIdx;
                    word = !word;
                }
            }

            curIdx++;
        }

        if (word) {
            endWord = curIdx;
        }

        return (beginWord != -1)?endWord-beginWord:0;
    }

    public static void main(String [ ] args) {
        System.out.print(lengthOfLastWord(" abc  kkkk ka  k  w"));
    }
}
