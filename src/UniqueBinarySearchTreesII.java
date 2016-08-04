import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    static public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        return bst(1,n);
    }

    static public List<TreeNode> bst (int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i=start;i<=end;i++) {
            List<TreeNode> left = bst(start,i-1);
            List<TreeNode> right = bst(i+1,end);
            for (TreeNode tnl : left) {
                for (TreeNode tnr : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = tnl;
                    root.right = tnr;
                    result.add(root);
                }
            }
        }

        return result;
    }

    public static void main(String [ ] args) {
        List<TreeNode> res = generateTrees(5);

        System.out.println(res.size());
        for (TreeNode tn : res) {
            System.out.println(BinaryTreeSerialization.serialize(tn));
        }
    }
}
