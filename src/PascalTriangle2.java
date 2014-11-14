import java.util.LinkedList;
import java.util.List;

public class PascalTriangle2 {
    static public List<Integer> getRow(int rowIndex) {

        List<Integer> res = new LinkedList<Integer>();
        res.add(1);

        int i = 0;
        while (i < rowIndex) {
            List<Integer> cand = new LinkedList<Integer>();
            cand.add(1);
            for (int j = 0;j<res.size()-1;j++) {
                cand.add(res.get(j)+res.get(j+1));
            }
            cand.add(1);
            i++;
            res = cand;
        }

        return res;
    }

    public static void main(String [ ] args) {
        List<Integer> res = getRow(0);

        for (int i : res) {
            System.out.println(i);
        }
    }
}
