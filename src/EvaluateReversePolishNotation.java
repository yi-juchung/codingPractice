import java.util.Stack;

public class EvaluateReversePolishNotation {
    static public int evalRPN(String[] tokens) {
        Stack<Integer> integers = new Stack<Integer>();
        int i = 0;
        int a,b;
        while (i < tokens.length) {
            if (tokens[i].equals("+")) {
                a = integers.pop();
                b = integers.pop();
                integers.push(a+b);
            } else if (tokens[i].equals("-")) {
                a = integers.pop();
                b = integers.pop();
                integers.push(b-a);
            } else if (tokens[i].equals("*")) {
                a = integers.pop();
                b = integers.pop();
                integers.push(b*a);
            } else if (tokens[i].equals("/")) {
                a = integers.pop();
                b = integers.pop();
                integers.push(b/a);
            } else {
                integers.push(Integer.parseInt(tokens[i]));
            }

            i++;
        }

        return integers.pop();
    }

    public static void main(String [ ] args) {
        String [] tokens = new String[] {"2", "1", "+", "3", "*"};
        System.out.print(evalRPN(tokens));
    }
}
