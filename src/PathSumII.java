import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    static public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        pathSumHelp(root, sum, new ArrayList<Integer>(), res);

        return res;
    }

    static public void pathSumHelp(TreeNode cur, int remain, ArrayList<Integer> curList, List<List<Integer>> res) {
        if (cur == null) {
            return;
        }

        curList.add(cur.val);

        if (cur.val == remain && cur.right == null && cur.left == null) {
            res.add((ArrayList)curList.clone());
        } else {
            pathSumHelp(cur.left, remain-cur.val, curList, res);
            pathSumHelp(cur.right, remain-cur.val, curList, res);
        }

        curList.remove(curList.size()-1);
    }

    public static void main(String [ ] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);

        List<List<Integer>> res = pathSum(root, 22);
        for( List<Integer> list : res) {
            for( int i : list) {
                System.out.print(i+",");
            }
            System.out.println();
        }
    }
}
