import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectBSTbyLevel {
    public static void connect(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        Queue<TreeNode> que = new LinkedList<>();
        if (root != null)
            que.add(root);

        while (!que.isEmpty()) {
            Queue<TreeNode> next = new LinkedList<>();
            TreeNode prev = null;
            while (!que.isEmpty()) {
                TreeNode cur = que.poll();

                if (prev != null) {
                    prev.next = cur;
                }

                if (cur.left != null)
                    next.add(cur.left);
                if (cur.right != null)
                    next.add(cur.right);

                prev = cur;
            }
            que = next;
        }
    }

    public static void main(String [ ] args) {
        TreeNode root = new TreeNode(11);

        root.left = new TreeNode(6);
        root.right = new TreeNode(19);

        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(10);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(23);

        connect(root);

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (root != null) {
            if (root.left != null) {
                que.add(root.left);
                root = root.left;
            } else {
                que.add(root.right);
                root = root.right;
            }
        }

        while (!que.isEmpty()) {
            TreeNode tn = que.poll();

            while (tn != null) {
                System.out.print(tn.val+",");
                tn = tn.next;
            }

            System.out.println();
        }
    }
}
