import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PatternMatching {
    static public boolean match(String pattern, String data) {
        HashMap<Character, String> check = new HashMap<>();
        Set<String> visited = new HashSet<>();

        return helper(pattern,data,0,0,check, visited);
    }

    static public boolean helper(String pattern, String data, int ip, int id, HashMap<Character,String> check, Set<String> visited) {
        if (ip >= pattern.length()) {
            return id >= data.length();
        } else if (id >= data.length()) {
            return false;
        }

        char p = pattern.charAt(ip);
        if (check.containsKey(p)) {
            String cand = check.get(p);
            return id+cand.length() <= data.length() && cand.equals(data.substring(id,id+cand.length()))
                    && helper(pattern,data,ip+1,id+cand.length(), check, visited);
        } else {

            for (int i=id+1;i<=data.length();i++) {
                String cand = data.substring(id,i);
                if (visited.contains(cand)) {
                    continue;
                }

                check.put(p,cand);
                visited.add(cand);
                if (helper(pattern,data,ip+1,i,check,visited)) {
                    return true;
                }
                check.remove(p);
                visited.remove(cand);
            }

            return false;
        }
    }

    public static void main(String [ ] args) {

        System.out.println(match("abba", "redbluebluered"));
        System.out.println(match("abba", "redblueYellowred"));
        System.out.println(match("aaaa", "redredredred"));
        System.out.println(match("abba", "redredredred"));
    }
}
