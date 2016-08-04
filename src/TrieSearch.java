import java.util.LinkedList;
import java.util.List;

public class TrieSearch {

    public static List<String> search (TrieNode tn, String s) {
        List<String> res = new LinkedList<>();

        helper(tn,new StringBuilder(),s,0,res, false);

        return res;
    }

    public static void helper (TrieNode tn, StringBuilder sb, String s, int i, List<String> res, boolean fromWild) {
        if (i == s.length()) {
            if (tn.isWord) {
                res.add(sb.toString());
            }
            return;
        }

        if (s.charAt(i) == '*') {
            if (!fromWild)
                helper(tn, sb, s, i+1, res, true);

            for (int j=0;j<26;j++) {
                if (tn.childs[j] != null) {
                    int len = sb.length();
                    sb.append((char)(j+'a'));
                    helper(tn.childs[j], sb, s, i+1, res, true);
                    helper(tn.childs[j], sb, s, i, res, true);
                    sb.deleteCharAt(len);
                }
            }
        } else if (tn.childs[s.charAt(i)-'a'] != null) {
            int len = sb.length();
            sb.append(s.charAt(i));
            helper(tn.childs[s.charAt(i)-'a'], sb, s, i+1, res, false);
            sb.deleteCharAt(len);
        }
    }

    public static void addWord (TrieNode tn, String s) {
        TrieNode cur = tn;
        for (int i=0;i<s.length();i++) {
            if (cur.childs[s.charAt(i)-'a'] == null) {
                cur.childs[s.charAt(i)-'a'] = new TrieNode();
            }
            cur = cur.childs[s.charAt(i)-'a'];
        }

        cur.isWord = true;
    }

    public static void main(String [ ] args) {
        TrieNode tn = new TrieNode();
        addWord(tn,"car");
        addWord(tn,"caw");
        addWord(tn,"cauw");
        addWord(tn,"cw");
        addWord(tn,"cauwww");

        for (String s : search(tn,"c*w")) {
            System.out.println(s);
        }
    }
}
