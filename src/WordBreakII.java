import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreakII {

    static public List<String> wordBreak(String s, Set<String> wordDict) {
        boolean [] noSol = new boolean[s.length()+1];
        List<String> res = new LinkedList<String>();
        helper(s,0,wordDict,noSol,res, "");
        return res;
    }

    static public void helper (String s, int start, Set<String> dict, boolean [] noSol, List<String> res, String cur) {
        if (start == s.length()) {
            res.add(cur.substring(1));
            return;
        }

        for (int i=start;i<s.length();i++) {
            String part = s.substring(start, i+1);

            if (dict.contains(part) && !noSol[i+1]) {
                int sol = res.size();
                helper(s,i+1, dict, noSol, res, cur+" "+part);
                if (sol == res.size()) {
                    noSol[i+1] = true;
                }
            }
        }
    }

    public static void main(String [ ] args) {
        //["cats and dog", "cat sand dog"]

        String s = "catsanddog";

        Set<String> dict = new HashSet<String>(){
            {add("cat");add("cats");add("and");add("sand");add("dog");}
        };

        System.out.print(wordBreak(s,dict));
    }
}
