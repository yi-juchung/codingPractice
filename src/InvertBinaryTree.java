public class InvertBinaryTree {
    static public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    static public void reverse(TreeNode root) {
        if (root == null)
            return ;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        reverse(root.left);
        reverse(root.right);
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

        // 8
        System.out.print(invertTree(root).left.val);
    }
}
