import java.util.LinkedList;
import java.util.Queue;

public class TreeSum {
//    public static int sum(TreeNode root) {
//        if (root == null)
//            return 0;
//
//        int left = sum(root.left);
//        int right = sum(root.right);
//
//        return left+right+root.val;
//    }

    public static int sum(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        cur.add(root);
        int total = 0;

        while(!cur.isEmpty()) {
            TreeNode tn = cur.poll();

            if (tn.left != null)
                cur.add(tn.left);
            if (tn.right != null)
                cur.add(tn.right);

            total += tn.val;
        }

        return total;
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

        System.out.println(sum(root));
    }
}
