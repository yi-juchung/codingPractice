import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {

    static public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        List<Integer> curList = new LinkedList<Integer>();

        if (root != null) {
            curList.add(root.val);
            queue.add(root);

            while(!queue.isEmpty()) {
                TreeNode curNode = queue.poll();

                if (curNode.left != null) {

                }
            }

        }

        res.add(curList);
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

        System.out.print(levelOrderBottom(root));
    }
}
