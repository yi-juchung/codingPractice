public class ReverseWordsInaString {
    static public String reverseWords(String s) {
        if (s.length() < 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();

        int beginWord = 0;
        int endWord = 0;

        while (beginWord < s.length()) {
            if (s.charAt(beginWord) != ' ') {
                endWord = beginWord+1;
                while(endWord < s.length()) {
                    if (s.charAt(endWord) == ' ') {
                        break;
                    } else {
                        endWord++;
                    }
                }

                reverseWord(sb, s, beginWord, endWord);
                sb.append(' ');

                beginWord = endWord;
            } else {
                beginWord++;
            }
        }

        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length()-1);
            sb.reverse();
        }

        return sb.toString();
    }

    static public void reverseWord(StringBuilder sb, String s, int begin, int end) {
        while (end != begin) {
            end--;
            sb.append(s.charAt(end));
        }
    }

    public static void main(String [ ] args) {
        System.out.print(reverseWords("the sky is blue"));
    }
}
