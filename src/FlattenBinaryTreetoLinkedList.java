public class FlattenBinaryTreetoLinkedList {
    static public void flatten(TreeNode root) {

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

        flatten(root);
        TreeNode cur = root;
        while (cur != null) {
            System.out.print(cur.val+"-");
            cur = cur.right;
        }
    }
}
