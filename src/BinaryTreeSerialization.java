public class BinaryTreeSerialization {
    static public String serialize (TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root,sb);
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    static public void helper (TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val+",");
        helper(root.left,sb);
        helper(root.right,sb);
    }

    public static void main(String [ ] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(serialize(root));
    }
}
