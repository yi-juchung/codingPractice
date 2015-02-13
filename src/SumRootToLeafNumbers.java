public class SumRootToLeafNumbers {
    static public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return addUpString(root, new StringBuilder());
    }

    static public int addUpString(TreeNode cur, StringBuilder sb) {
        sb.append(cur.val);
        int res;
        if (cur.left == null && cur.right == null) {
            res = Integer.parseInt(sb.toString());
            sb.deleteCharAt(sb.length()-1);
            return res;
        } else if (cur.left == null) {
            res = addUpString(cur.right,sb);
            sb.deleteCharAt(sb.length()-1);
            return res;
        } else if (cur.right == null) {
            res = addUpString(cur.left,sb);
            sb.deleteCharAt(sb.length()-1);
            return res;
        }

        res = addUpString(cur.right,sb)+addUpString(cur.left,sb);
        sb.deleteCharAt(sb.length()-1);
        return res;
    }

    public static void main(String [ ] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.print(sumNumbers(root));
    }
}
