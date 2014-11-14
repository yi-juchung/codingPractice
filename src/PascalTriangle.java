import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer> > res = new LinkedList<List<Integer>>();
        List<Integer> cand = new LinkedList<Integer>();

        if (numRows > 0) {
            cand.add(1);
            res.add(cand);
        }

        int i = 1;
        while (i < numRows) {
            List<Integer> cur = new LinkedList<Integer>();
            cur.add(1);
            for (int j = 0;j<cand.size()-1;j++) {
                cur.add(cand.get(j)+cand.get(j+1));
            }
            cur.add(1);
            i++;
            res.add(cur);
            cand = cur;
        }

        return res;
    }
}
