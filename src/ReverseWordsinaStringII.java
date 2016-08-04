public class ReverseWordsinaStringII {
    static public String reverseWords(String s) {
        char [] chars = s.toCharArray();

        reverse(chars,0,chars.length-1);

        int begin = 0;
        int end = 0;

        for (;begin<chars.length;begin++) {
            if (chars[begin] != ' ') {
                end = begin+1;
                while (end < chars.length && chars[end] != ' ') {
                    end++;
                }
                reverse(chars,begin,end-1);
                begin = end;
            }
        }

        return new String(chars);
    }

    static public void reverse (char [] chars, int i, int j) {
        while (i<j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++; j--;
        }
    }

    public static void main(String [ ] args) {
        System.out.print(reverseWords("the sky is blue"));
    }
}
