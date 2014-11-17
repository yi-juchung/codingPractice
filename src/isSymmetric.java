public class isSymmetric {
    static public boolean isSymmetric(TreeNode root) {

        return root == null || isSymmetricHelper(root.left,root.right);
    }

    static public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        else if (left == null)
            return false;
        else if (right == null)
            return false;

        if (left.val == right.val) {
            return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
        } else {
            return false;
        }
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

        System.out.print(isSymmetric(root));
    }
}
