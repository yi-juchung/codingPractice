import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    static public List<String> generateParenthesis(int n) {
        List<String> s = new LinkedList<String>();

        if (n == 1) {
            s.add("()");
        } else {
            helper(s,new String(), n, n);
        }

        return s;
    }

    static public void helper(List<String> res, String sb, int left, int right) {
        if (left > right)
            return;

        if (left == 0 && right == 0) {
            res.add(sb);
            return;
        }

        if (left > 0) {
            helper(res, sb+"(", left-1,right);
        }

        if (right > 0) {
            helper(res, sb+")", left,right-1);
        }
    }

    public static void main(String [ ] args) {

        List<String> res = generateParenthesis(3);

        for (String s : res) {
            System.out.println(s);
        }
    }
}
