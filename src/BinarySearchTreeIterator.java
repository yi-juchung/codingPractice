import java.util.LinkedList;
import java.util.Stack;

public class BinarySearchTreeIterator {
    public static class BSTIterator {

        Stack<TreeNode> path;

        public BSTIterator(TreeNode root) {
            path = new Stack<TreeNode>();

            while (root != null) {
                path.push(root);
                root = root.left;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !path.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode cur = path.pop();
            TreeNode left = cur.right;

            while (left != null) {
                path.push(left);
                left = left.left;
            }

            return cur.val;
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

        BSTIterator i = new BSTIterator(root);
        while (i.hasNext()) System.out.println(i.next());
    }
}
