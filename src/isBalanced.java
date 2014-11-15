public class isBalanced {

    static public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root) != -1;
    }

    static public int isBalancedHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = isBalancedHelper(root.left);
        int right = isBalancedHelper(root.right);

        if (left == -1 || right == -1) {
            return -1;
        }

        if (Math.abs(left-right) > 1 ) {
            return -1;
        }

        return Math.max(left,right)+1;
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

        System.out.print(isBalanced(root));
    }
}
