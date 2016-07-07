import java.util.Stack;

public class InorderSuccessorinBST {
    static public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;

        TreeNode cur = root;

        while (cur.val != p.val) {
            if (p.val > cur.val) {

                if (res != null && res.val < cur.val) {
                    res = cur;
                }

                cur = cur.right;
            } else {
                res = cur;
                cur = cur.left;
            }
        }

        if (res == null) {
            res = findMin(cur.right);
        }

        return res;
    }

    static public TreeNode findMin(TreeNode root) {
        TreeNode tn = root;

        while (tn != null && tn.left != null) {
            tn = tn.left;
        }

        return tn;
    }

    public static void main(String [ ] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(2);
        root.right = new TreeNode(9);

        // 5
        System.out.println(inorderSuccessor(root,root.left).val);

        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(13);

        // 5
        System.out.println(inorderSuccessor(root,root.left.right).val);

        System.out.println(inorderSuccessor(root,root.right.right) == null);
    }
}
