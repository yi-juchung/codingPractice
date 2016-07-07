public class BinaryTreeLongestConsecutiveSequence {
    static public int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;

        return helper(root, 0, root.val-1);
    }

    static public int helper(TreeNode root, int len, int pre) {
        if (root == null) {
            return len;
        }

        int curLen = (root.val == pre+1)?len+1:1;

        return Math.max(helper(root.left, curLen, root.val), helper(root.right, curLen, root.val));
    }

//    static public int longestConsecutive(TreeNode root) {
//        int [] res = helper(root);
//        return Math.max(res[0],res[1]);
//    }
//
//    static public int [] helper(TreeNode root) {
//        if (root == null)
//            return new int [2];
//
//        int [] l = helper(root.left);
//        int [] r = helper(root.right);
//
//        int [] res = new int [2];
//        res[0] = 1;
//        res[1] = 0;
//        if (root.left != null) {
//            if (root.left.val == root.val+1) {
//                res[0] = l[0]+1;
//            } else {
//                res[1] = Math.max(l[0],l[1]);
//            }
//        }
//
//        if (root.right != null) {
//            if (root.right.val == root.val+1) {
//                res[0] = Math.max(r[0]+1, res[0]);
//            } else {
//                res[1] = Math.max(Math.max(r[0],r[1]), res[1]);
//            }
//        }
//
//        return res;
//    }

    public static void main(String [ ] args) {
        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.left = new TreeNode(2);

        System.out.println(longestConsecutive(root));
    }
}
