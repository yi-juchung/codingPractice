import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    static public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<List<String>>();
        ArrayList<ArrayList<Integer>> pas = new ArrayList<ArrayList<Integer>>();
        for (int i=0;i<s.length();i++) {
            pas.add(new ArrayList<Integer>());
        }

        boolean [][] mtx = new boolean [s.length()][s.length()];

        for (int len=1;len<=s.length();len++) {
            for (int i=0;i<s.length()-len+1;i++) {
                if (len==1) {
                    mtx[i][i] = true;
                    pas.get(i).add(i);
                } else if (len == 2 && s.charAt(i) == s.charAt(i+1)) {
                    mtx[i][i+1] = true;
                    pas.get(i).add(i+1);
                } else if (mtx[i+1][i+len-2] && s.charAt(i) == s.charAt(i+len-1)) {
                    mtx[i][i+len-1] = true;
                    pas.get(i).add(i+len-1);
                }
            }
        }

        ArrayList<String> curList = new ArrayList<String>();
        dfs(res, s, 0, pas, curList);

        return res;
    }

    public static void dfs(List<List<String>> res, String s, int curIdx, ArrayList<ArrayList<Integer>> pas, ArrayList<String> cur) {
        if (curIdx == s.length()) {
            res.add((ArrayList<String>)cur.clone());
            return;
        }

        for (int i = 0; i < pas.get(curIdx).size(); ++i ) {
            cur.add(s.substring(curIdx, pas.get(curIdx).get(i)+1));
            dfs( res, s, pas.get(curIdx).get(i)+1, pas, cur );
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String [ ] args) {
        List<List<String>> res = partition("aab");

        for (List<String> list : res) {
            for (String s : list) {
                System.out.print(s+",");
            }

            System.out.println();
        }
    }
}
