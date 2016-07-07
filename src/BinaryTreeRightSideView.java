import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
    static public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer,Integer> res = new HashMap<Integer, Integer>();

        helper(res, root, 0);

        return new LinkedList<Integer>(res.values());
    }

    static public void helper(HashMap<Integer,Integer> curMap, TreeNode cur, int dep) {
        if (cur == null)
            return;

        curMap.put(dep, cur.val);
        helper(curMap, cur.left, dep+1);
        helper(curMap, cur.right, dep+1);
    }

    public static void main(String [ ] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> res = rightSideView(root);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
