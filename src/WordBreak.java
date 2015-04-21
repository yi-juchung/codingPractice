import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    static public boolean wordBreak(String s, Set<String> wordDict) {
        boolean [] mem = new boolean[s.length()+1];
        mem[s.length()] = true;
        return help(s,s.length()-1,wordDict,mem);
    }

    static public boolean help(String s, int idx, Set<String> dict, boolean [] mem) {
        if (idx < 0) {
            return mem[0];
        }

        for (int i = idx;i<s.length();i++) {
            String sub = s.substring(idx,i+1);

            if (dict.contains(sub) && mem[i+1]) {
                mem[idx] = true;
                break;
            }
        }

        return help(s,idx-1,dict,mem);
    }

    public static void main(String [ ] args) {
        String s = "leetcode";

        Set<String> dict = new HashSet<String>(){
            {add("leet");add("code");}
        };

        System.out.print(wordBreak(s,dict));
    }
}
