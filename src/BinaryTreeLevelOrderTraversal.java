import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    static public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        Queue<TreeNode> que = new LinkedList<>();
        if (root != null)
            que.add(root);

        while (!que.isEmpty()) {
            Queue<TreeNode> next = new LinkedList<>();
            List<Integer> curLevel = new LinkedList<>();
            while (!que.isEmpty()) {
                TreeNode cur = que.poll();
                curLevel.add(cur.val);
                if (cur.left != null)
                    next.add(cur.left);
                if (cur.right != null)
                    next.add(cur.right);
            }

            res.add(curLevel);
            que = next;
        }

        return res;
    }

    public static void main(String [ ] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        for (List<Integer> l : levelOrder(root)) {
            System.out.println(l);
        }
    }
}
