import java.util.LinkedList;
import java.util.List;

public class Triangle {
    static public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int rowNum = triangle.size();
        int [] res = new int[rowNum];
        for (int i=0;i<triangle.get(rowNum-1).size();i++) {
            res[i] = triangle.get(rowNum-1).get(i);
        }

        for (int row=rowNum-2;row >= 0;row--) {
            for (int col=0;col <= row;col++) {
                res[col] = Math.min(res[col],res[col+1])+triangle.get(row).get(col);
            }
        }

        return res[0];
    }

    public static void main(String [ ] args) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();

        lists.add(new LinkedList<Integer>(){{add(2);}});
        lists.add(new LinkedList<Integer>(){{add(3);add(4);}});
        lists.add(new LinkedList<Integer>(){{add(6);add(5);add(7);}});
        lists.add(new LinkedList<Integer>(){{add(4);add(1);add(8);add(3);}});

        System.out.print(minimumTotal(lists));
    }
}
