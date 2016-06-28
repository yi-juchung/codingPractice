import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    static public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root != null){
            treeHelper(root, new StringBuilder(),res);
        }

        return res;
    }

    static public void treeHelper(TreeNode cur, StringBuilder sb, List<String> res) {
        if (cur.left == null && cur.right == null) {
            String valS = Integer.toString(cur.val);
            sb.append(valS);
            res.add(sb.toString());
            int len = sb.length();
            sb.delete(len-valS.length(),len);
            return;
        }
        String next = cur.val+"->";
        sb.append(next);
        if (cur.left != null) {
            treeHelper(cur.left, sb, res);
        }

        if (cur.right != null) {
            treeHelper(cur.right, sb, res);
        }
        int len = sb.length();
        sb.delete(len-next.length(), len);
    }

    public static void main(String [ ] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> res = binaryTreePaths(root);
        for (String i : res) {
            System.out.println(i);
        }
    }
}
