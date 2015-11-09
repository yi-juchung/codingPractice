import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class IsomorphicStrings {
    static public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character,Character> m = new HashMap<Character, Character>();
        Set<Character> check = new HashSet<Character>();

        for (int i=0;i<s.length();i++) {
            Character c = s.charAt(i);

            if (m.containsKey(c)) {
                if (m.get(c) != t.charAt(i)) {
                    return false;
                }
            } else {
                Character c2 = t.charAt(i);
                if (check.contains(c2)) {
                    return false;
                }

                check.add(c2);
                m.put(c,c2);
            }
        }

        return true;
    }

    public static void main(String [ ] args) {
        System.out.print(isIsomorphic("foo", "baa"));
    }
}
