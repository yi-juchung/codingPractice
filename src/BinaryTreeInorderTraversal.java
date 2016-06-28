import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
//    static public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new LinkedList<>();
//
//        helper(res,root);
//
//        return res;
//    }
//
//    static public void helper(List<Integer> res, TreeNode root) {
//        if (root == null)
//            return;
//
//        helper(res,root.left);
//        res.add(root.val);
//        helper(res,root.right);
//    }

    static public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        Stack<TreeNode> tn = new Stack<>();

        TreeNode cur = root;
        while (!tn.isEmpty() || cur != null) {
            if (cur == null) {
                TreeNode t = tn.pop();
                res.add(t.val);
                cur = t.right;
            } else {
                tn.push(cur);
                cur = cur.left;
            }
        }

        return res;
    }

    public static void main(String [ ] args) {
        TreeNode root = new TreeNode(11);

        root.left = new TreeNode(6);
        root.right = new TreeNode(19);

        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(10);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(23);

        for (int i : inorderTraversal(root)) {
            System.out.println(i);
        }
    }
}
