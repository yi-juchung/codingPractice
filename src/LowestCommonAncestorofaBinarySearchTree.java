public class LowestCommonAncestorofaBinarySearchTree {
    static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return root;

        if (root == p) {
            return p;
        } else if (root == q) {
            return q;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null && right == null){
            return left;
        } else if (right != null && left == null) {
            return right;
        }

        return null;
    }

    public static void main(String [ ] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        System.out.println(lowestCommonAncestor(root, root.left.left.left, root.left.right).val);
    }
}
