import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CombinationSumIII {
    static public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new LinkedList<List<Integer>>();

        Set<Integer> curSet = new HashSet<Integer>();
        for (int i=1;i<11-k;i++) {

            curSet.add(i);
            helper(curSet, i, k - 1, n - i, res);
            curSet.remove(i);
        }

        return res;
    }

    static public void helper (Set<Integer> curlist, int i, int round, int n, List<List<Integer>> res) {
        if (round == 0) {
            if (n == 0)
                res.add(new LinkedList<Integer>(curlist));
            else return;
        }

        if (n <= 0) {
            return;
        }

        for (int j = i+1;j<=9;j++) {
            curlist.add(j);
            helper(curlist, j, round-1, n-j, res);
            curlist.remove(j);
        }
    }

    public static void main(String [ ] args) {

        for(List<Integer> list : combinationSum3(3, 9)) {
            for(int i : list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
