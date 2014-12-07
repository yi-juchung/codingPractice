import java.util.Stack;

public class ValidParentheses {
    static public boolean isValid(String s) {
        Stack<Character> prevChars = new Stack<Character>();

        int curChar = 0;

        while(curChar < s.length()) {
            char cur = s.charAt(curChar);

            switch (cur) {
                case '}':
                    if (prevChars.isEmpty() || prevChars.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (prevChars.isEmpty() || prevChars.pop() != '[')
                        return false;
                    break;
                case ')':
                    if (prevChars.isEmpty() || prevChars.pop() != '(')
                        return false;
                    break;
                default:
                    prevChars.push(cur);
                    break;
            }

            curChar++;
        }

        return prevChars.isEmpty();
    }

    public static void main(String [ ] args) {
        System.out.print(isValid("()[]{}"));
    }
}
