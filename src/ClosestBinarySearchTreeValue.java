public class ClosestBinarySearchTreeValue {
    public static int closest(TreeNode root, int k) {
        return closestHelper(root, k, -1, Integer.MAX_VALUE);
    }

    public int closestV2(TreeNode root, int target) {
        TreeNode node = (root.val>target)?root.left:root.right;
        if (node == null) {
            return root.val;
        }
        int value = closestV2(node, target);
        return Math.abs(root.val-target) > Math.abs(value-target)?value:root.val;
    }

    public static int closestHelper(TreeNode root, int k, int cand,int minDiff) {
        int curDiff = Math.abs(root.val-k);
        if (curDiff < minDiff) {
            minDiff = curDiff;
            cand = root.val;
        }

        int nextLevel = cand;
        if (k > root.val && root.right != null) {
            nextLevel = closestHelper(root.right, k, cand, minDiff);
        } else if (root.left != null) {
            nextLevel = closestHelper(root.left, k, cand, minDiff);
        }

        return nextLevel;
    }

    public static void main(String [ ] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(11);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(13);
        root.right.right.left = new TreeNode(12);

        System.out.println(closest(root, 8));
    }
}
