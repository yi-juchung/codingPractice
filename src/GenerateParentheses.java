import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    static public List<String> generateParenthesisIter(int n) {
        List<String> s = new LinkedList<String>();

        Stack<Pair<Integer,Integer>> pairs = new Stack<Pair<Integer, Integer>>();
        Stack<String> res = new Stack<String>();
        pairs.add(new Pair<Integer, Integer>(3,3));
        res.add("");

        while(!pairs.isEmpty()) {
            Pair<Integer,Integer> p = pairs.pop();
            String st = res.pop();

            if (p.getKey() > p.getValue())
                continue;

            if (p.getValue() == 0 && p.getKey() == 0) {
                s.add(st);
            }

            if (p.getKey() > 0) {
                pairs.add(new Pair<Integer, Integer>(p.getKey()-1,p.getValue()));
                res.add(st+"(");
            }

            if (p.getValue() > 0) {
                pairs.add(new Pair<Integer, Integer>(p.getKey(),p.getValue()-1));
                res.add(st+")");
            }
        }

        return s;
    }

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

        List<String> res = generateParenthesisIter(3);

        for (String s : res) {
            System.out.println(s);
        }
    }
}
