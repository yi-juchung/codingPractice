import java.util.LinkedList;

public class LongestValidParentheses {
    static public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int result = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return result;
    }

    public static void main(String [ ] args) {

        // 2
        System.out.println(longestValidParentheses("(()"));
        // 4
        System.out.println(longestValidParentheses(")()())"));
    }
}
