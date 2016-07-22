import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BinaryTreeVerticalOrderTraversal {
    public static List<List<Integer>> vertical(TreeNode root) {
        Map<Integer, List<Integer>> resMap = new TreeMap<>();

        helper(0,root, resMap);

        List<List<Integer>> res = new LinkedList<>();

        for (List<Integer> l : resMap.values()) {
            res.add(l);
        }

        return res;
    }

    public static void helper (int level, TreeNode root, Map<Integer, List<Integer>> resMap) {
        if (root == null) {
            return;
        }

        if (resMap.containsKey(level)) {
            resMap.get(level).add(root.val);
        } else {
            resMap.put(level, new LinkedList<Integer>(){{ add(root.val); }});
        }

        helper(level-1, root.left, resMap);
        helper(level+1, root.right, resMap);
    }

    public static void main(String [ ] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);

        System.out.println(vertical(root));

        root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(8);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.left.right.right = new TreeNode(2);
        root.right.left.left = new TreeNode(5);

        System.out.println(vertical(root));
    }
}
