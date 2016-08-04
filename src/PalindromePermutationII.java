import java.util.LinkedList;
import java.util.List;

public class PalindromePermutationII {
    static public List<String> generatePalindromes(String s) {
        List<String> res = new LinkedList<>();
        char [] chars = s.toCharArray();
        int [] count = new int [26];

        for (char c : chars) {
            count[c-'a']++;
        }

        char odd = '%';
        for (int i=0;i<count.length;i++) {
            if (count[i]%2 == 0) {
                count[i] /= 2;
            } else {
                if (odd == '%') {
                    odd = (char)(i+'a');
                } else {
                    return res;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<count.length;i++) {
            while (count[i] != 0) {
                sb.append((char)(i+'a'));
                count[i]--;
            }
        }

        helper(sb.toString().toCharArray(),0,odd,res);

        return res;
    }

    static public void helper (char [] chars, int start, char alone, List<String> res) {
        if (start >= chars.length) {
            StringBuilder sb = new StringBuilder();
            sb.append(chars);
            String pre = sb.toString();
            sb.reverse();
            String post = sb.toString();
            if (alone != '%') {
                pre = pre+alone+post;
            } else {
                pre += post;
            }
            res.add(pre);
            return;
        }

        for (int i=start;i<chars.length;i++) {
            if (i != start && chars[i] == chars[i-1]) {
                continue;
            }

            swap(chars,start,i);
            helper(chars,start+1,alone,res);
            swap(chars,start,i);
        }
    }

    static public void swap(char [] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String [ ] args) {
        for (String s : generatePalindromes("aabb")) {
            System.out.println(s);
        }

        for (String s : generatePalindromes("abc")) {
            System.out.println(s);
        }
    }
}
