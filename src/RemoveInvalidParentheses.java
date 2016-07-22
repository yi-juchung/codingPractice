import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {
    static public List<String> removeInvalidParentheses(String s) {
        List<String> sol = new LinkedList<>();

        if (s.length() == 0) {
            return sol;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> next = new LinkedList<>();
        next.add(s);
        visited.add(s);
        boolean found = false;

        while (!next.isEmpty()) {
            int curLevelLen = next.size();

            for (int i=0;i<curLevelLen;i++) {
                s = next.poll();

                if (isValid(s)) {
                    found = true;
                    sol.add(s);
                }

                if (!found) {
                    for (int j=0;j<s.length();j++) {
                        if (s.charAt(j) != '(' && s.charAt(j) != ')') {
                            continue;
                        }

                        String newS = s.substring(0,j)+s.substring(j+1);

                        if (!visited.contains(newS)) {
                            visited.add(newS);
                            next.add(newS);
                        }
                    }
                }
            }

            if (found) {
                break;
            }
        }

        if (sol.isEmpty()) {
            sol.add("");
        }

        return sol;
    }

    static public boolean isValid(String s) {
        int count = 0;

        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }

    public static void main(String [ ] args) {

        // ["()()()", "(())()"]
        System.out.println(removeInvalidParentheses("()())()"));

        // ["(a)()()", "(a())()"]
        System.out.println(removeInvalidParentheses("(a)())()"));

        // [""]
        System.out.println(removeInvalidParentheses(")("));
    }
}
