import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DifferentWaystoAddParentheses {
    static public List<Integer> diffWaysToCompute(String input) {
        String [] strings = input.split("(?=[\\+\\-\\*])|(?<=[\\+\\-\\*])");

        return computeAll(strings, 0, strings.length-1);
    }

    static public boolean isNumber(String s) {
        return Character.isDigit(s.charAt(0));
    }

    static public List<Integer> computeAll(String [] strings, int start, int end) {
        if (start == end) {
            return Arrays.asList(Integer.parseInt(strings[start]));
        } else if (start > end) {
            return new LinkedList<>();
        }

        List<Integer> ret = new LinkedList<>();

        for (int i=start;i<=end;i++) {
            if (isNumber(strings[i])) {
                continue;
            }
            List<Integer> left = computeAll(strings,start,i-1);
            List<Integer> right = computeAll(strings,i+1,end);

            for (int j=0;j<left.size();j++) {
                for (int k=0;k<right.size();k++) {
                    ret.add(compute(strings[i],left.get(j), right.get(k)));
                }
            }
        }

        return ret;
    }

    static public int compute(String o, int a, int b) {
        switch (o.charAt(0)) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            default:
                return 0;
        }
    }

    public static void main(String [ ] args) {
        List<Integer> res = diffWaysToCompute("2*3-4*5");

        for (int i : res) {
            System.out.println(i);
        }
    }
}
