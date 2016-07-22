public class ReverseWordsInaString {
//    static public String reverseWords(String s) {
//        if (s.length() < 1) {
//            return s;
//        }
//        StringBuilder sb = new StringBuilder();
//
//        int beginWord = 0;
//        int endWord = 0;
//
//        while (beginWord < s.length()) {
//            if (s.charAt(beginWord) != ' ') {
//                endWord = beginWord+1;
//                while(endWord < s.length()) {
//                    if (s.charAt(endWord) == ' ') {
//                        break;
//                    } else {
//                        endWord++;
//                    }
//                }
//
//                reverseWord(sb, s, beginWord, endWord);
//                sb.append(' ');
//
//                beginWord = endWord;
//            } else {
//                beginWord++;
//            }
//        }
//
//        if (sb.length() > 1) {
//            sb.deleteCharAt(sb.length()-1);
//            sb.reverse();
//        }
//
//        return sb.toString();
//    }
//
//    static public void reverseWord(StringBuilder sb, String s, int begin, int end) {
//        while (end != begin) {
//            end--;
//            sb.append(s.charAt(end));
//        }
//    }

    static public String reverseWords(String s) {
        char [] chars = s.toCharArray();

        int begin = 0;
        int end = 0;

        while (begin < s.length()) {
            if (chars[begin] != ' ') {
                end = begin+1;
                while (end < s.length()) {
                    if (chars[end] == ' ') {
                        break;
                    } else {
                        end++;
                    }
                }

                reverseWord(chars,begin,end-1);

                begin = end+1;
            } else {
                begin++;
            }
        }

        reverseWord(chars,0,chars.length-1);

        return new String(chars);
    }

    static public void reverseWord(char [] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++; end--;
        }
    }

    public static void main(String [ ] args) {
        System.out.print(reverseWords("the sky is blue"));
    }
}
