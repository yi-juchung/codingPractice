import java.util.Stack;

public class BinaryTreeUpsideDown {
//    static public TreeNode upsideDown(TreeNode root) {
//        Stack<TreeNode> tn = new Stack<>();
//
//        TreeNode cur = root;
//        while (cur.left != null) {
//            tn.push(cur);
//            cur = cur.left;
//        }
//
//        TreeNode newRoot = cur;
//        while (!tn.isEmpty()) {
//            TreeNode next = tn.pop();
//
//            cur.left = next.right;
//            cur.right = next;
//
//            cur = next;
//        }
//
//        cur.left = null;
//        cur.right = null;
//
//        return newRoot;
//    }

    static public TreeNode upsideDown(TreeNode root) {
        if (root == null)
            return null;

        return upsideDownHelper(root, null);
    }

    static public TreeNode upsideDownHelper (TreeNode root, TreeNode par) {
        if (root == null)
            return par;

        TreeNode newPar = upsideDownHelper(root.left, root);

        root.left = (par == null)?null:par.right;
        root.right = par;

        return newPar;
    }

    static public void helper(TreeNode root) {
        if (root == null)
            return;

        System.out.println(root.val);
        helper(root.left);
        helper(root.right);
    }

    public static void main(String [ ] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        helper(root);
        TreeNode down = upsideDown(root);

        helper(down);
    }
}
