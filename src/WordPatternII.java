import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordPatternII {

    static public boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> to = new HashMap<Character, String>();
        Set<String> occured = new HashSet<String>();

        return isMatch(to,occured,0,str, 0,pattern);
    }

    static public boolean isMatch(HashMap<Character,String> to, Set<String> occured, int curStr, String str, int curPat,String pattern) {
        if (curStr == str.length() && curPat == pattern.length()) {
            return true;
        } else if (curStr == str.length() || curPat == pattern.length()) {
            return false;
        }

        Character c = pattern.charAt(curPat);

        if (to.containsKey(c)) {
            String word = to.get(c);

            if (!str.startsWith(word,curStr)) {
                return false;
            }

            return isMatch(to,occured,curStr+word.length(),str,curPat+1,pattern);
        }

        for (int i=curStr;i<str.length();i++) {
            String word = str.substring(curStr,i+1);

            if (occured.contains(word))
                continue;

            to.put(c,word);
            occured.add(word);

            if (isMatch(to,occured,i+1,str,curPat+1,pattern)) {
                return true;
            }

            to.remove(c);
            occured.remove(word);
        }

        return false;
    }

    public static void main(String [ ] args) {
        //System.out.print(wordPattern("aabb", "xyzabcxzyabc"));
        System.out.print(wordPattern("abab", "redblueredblue"));
        //System.out.print(wordPattern("aba", "aaaa"));
    }
}
