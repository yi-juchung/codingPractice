public class FlattenBinaryTreetoLinkedList {
    static public void flatten(TreeNode root) {
        flattenHelper(root);
    }

    static public TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
            return root;
        }

        if (root.left == null && root.right == null) {
            return root;
        } else if (root.right == null) {
            // have left child
            TreeNode lastNode = flattenHelper(root.left);
            root.right = root.left;
            root.left = null;
            return lastNode;
        } else if (root.left == null){
            // have right child
            return flattenHelper(root.right);
        } else {
            // have both
            TreeNode oriRight = root.right;
            TreeNode lastNode = flattenHelper(root.left);
            root.right = root.left;
            root.left = null;
            lastNode.right = oriRight;
            return flattenHelper(root.right);
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

        flatten(root);
        TreeNode cur = root;
        while (cur != null) {
            System.out.print(cur.val+"-");
            cur = cur.right;
        }
    }
}
