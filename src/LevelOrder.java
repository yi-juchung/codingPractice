import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    static public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new LinkedList<List<Integer>>();

        Queue<TreeNode> curQueue = new LinkedList<TreeNode>();

        if (root != null)
            curQueue.add(root);

        while (!curQueue.isEmpty()) {
            Queue<TreeNode> nextQueue = new LinkedList<TreeNode>();
            List<Integer> curList = new LinkedList<Integer>();

            while (!curQueue.isEmpty()) {

                TreeNode curNode = curQueue.poll();

                if (curNode.left != null)
                    nextQueue.add(curNode.left);
                if (curNode.right != null)
                    nextQueue.add(curNode.right);

                curList.add(curNode.val);
            }

            res.add(curList);
            curQueue = nextQueue;
        }

        return res;
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

        System.out.print(levelOrder(root));
    }
}
