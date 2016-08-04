import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    static public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        List<Integer> cur = new LinkedList<>();
        boolean next = false;
        while(!que.isEmpty()) {
            Queue<TreeNode> nextLevel = new LinkedList<>();

            while (!que.isEmpty()) {
                TreeNode tn = que.poll();
                cur.add(tn.val);
                if (tn.left != null) {
                    nextLevel.add(tn.left);
                }
                if (tn.right != null) {
                    nextLevel.add(tn.right);
                }
            }

            if (next) {
                Collections.reverse(cur);
            }

            List<Integer> clone = new ArrayList<>(cur);
            res.add(clone);

            cur.clear();

            que = nextLevel;
            next = !next;
        }

        return res;
    }

    public static void main(String [ ] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        for (List<Integer> l : zigzagLevelOrder(root)) {
            System.out.println(l);
        }
    }
}
