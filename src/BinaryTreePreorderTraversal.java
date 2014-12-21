import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    static public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();

        helperv2(root, res);

        return res;
    }

    static public void helper (TreeNode cur, List<Integer> res) {
        if (cur != null) {
            res.add(cur.val);

            helper(cur.left, res);
            helper(cur.right, res);
        }
    }

    static public void helperv2(TreeNode cur, List<Integer> res) {
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        if (cur != null)
            nodeStack.push(cur);

        while(!nodeStack.empty()) {
            TreeNode curNode = nodeStack.pop();
            res.add(curNode.val);

            if (curNode.right != null)
                nodeStack.push(curNode.right);
            if (curNode.left != null)
                nodeStack.push(curNode.left);
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

        List<Integer> res = preorderTraversal(root);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
