public class KthSmallestElementinaBST {
    static public int kthSmallest(TreeNode root, int k) {
        return helper(root,k,new int[1]);
    }

    static public int helper(TreeNode root, int k, int [] res) {
        if (root == null) {
            res[0] = k;
            return -1;
        } else {
            int cand = helper(root.left, k, res);
            if (cand != -1) {
                return cand;
            }

            k = res[0];

            if (k == 1) {
                return root.val;
            }

            cand = helper(root.right, k-1, res);
            if (cand != -1) {
                return cand;
            }

            return -1;
        }
    }

    public static void main(String [ ] args) {
        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(1);
//        root.right = new TreeNode(8);
//
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.right = new TreeNode(1);

        System.out.print(kthSmallest(root, 2));
    }
}
