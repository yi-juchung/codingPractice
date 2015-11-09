import java.util.Stack;

class Calculator {

    static class Operators {

    }

    static int calc (String s) {

        Stack<String> operators = new Stack<String>();
        Stack<String> numbers = new Stack<String>();

        for (String sToken : s.split(" ")) {

            if (sToken.equals("(")) {
                numbers.push(sToken);
            } else if (sToken.equals(")")) {
                numbers.push(String.valueOf(calcStack(operators.pop(), numbers)));
            } else {
                if (sToken.matches("[-+]?\\d*\\.?\\d+")) {
                    numbers.push(sToken);
                } else {
                    operators.push(sToken);
                }
            }
        }

        return Integer.parseInt(numbers.pop());
    }

    static int calcStack(String c,Stack<String> numbers) {

        Stack<Integer> nums = new Stack<Integer>();

        while(!numbers.peek().equals("("))
            nums.push(Integer.parseInt(numbers.pop()));

        numbers.pop();

        int res = nums.pop();

        while(!nums.isEmpty()){
            int num = nums.pop();

            if (c.equals("+")) {
                res += num;
            } else if (c.equals("-")) {
                res -= num;
            } else if (c.equals("*")) {
                res *= num;
            } else if (c.equals("/")) {
                res /= num;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "( - ( + 10 5 ) ( * 2 ( / 6 2 ) ) 2 )";

        System.out.print(calc(s));
    }
}