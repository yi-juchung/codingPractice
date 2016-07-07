public class HouseRobberIII {
    static public int rob(TreeNode root) {
        int [] res = helper(root);
        return Math.max(res[0],res[1]);
    }

    static public int [] helper(TreeNode root) {
        if (root == null) {
            return new int [2];
        }

        int [] l = helper(root.left);
        int [] r = helper(root.right);

        int [] res = new int [2];

        res[0] += root.val+l[1]+r[1];
        res[1] = Math.max(l[0],l[1])+Math.max(r[0],r[1]);

        return res;
    }

    public static void main(String [ ] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println(rob(root));

        root = new TreeNode(3);

        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println(rob(root));
    }
}
