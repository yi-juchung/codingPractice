public class CountUnivalueSubtrees {
    static public int countUnivalSubtrees(TreeNode root) {
        return helper(root);
    }

    static public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = helper(root.left);
        int r = helper(root.right);
        int t = l + r;
        if (l != 0 && r != 0) {
            if (root.left.val == root.right.val && root.left.val == root.val) {
                t = l + r + 1;
            } else {
                t = l + r;
            }
        } else if (l != 0 && root.val == root.left.val) {
            t = l + 1;
        } else if (r != 0 && root.val == root.right.val) {
            t = r + 1;
        } else if (l == 0 && r == 0) {
            t = 1;
        }

        return t;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.right = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(5);

        System.out.println(countUnivalSubtrees(root));
    }
}
