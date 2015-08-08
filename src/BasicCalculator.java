import java.util.Stack;

public class BasicCalculator {
    static public int calculate(String s) {
        Stack<Integer> nums = new Stack<Integer>();

        int res = 0;
        int num = 0;
        int sign = 1;
        for (int i=0;i<s.length();i++) {
            Character c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10*num+c-'0';
            } else if (c == '+' || c == '-') {
                res += num*sign;
                sign = (c == '+')?1:-1;
                num = 0;
            } else if (c == '(') {
                nums.push(res);
                nums.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += num*sign;
                res *= nums.pop();
                res += nums.pop();
                num = 0;
            }
        }

        if (num != 0) {
            res += num*sign;
        }

        return res;
    }

    public static void main(String [ ] args) {

        //String s = "(1+(4+5+2)-3)+(6+8)";
        //String s = "2147483647";
        String s = " 2-1 + 2 ";
        System.out.print(calculate(s));
    }
}
