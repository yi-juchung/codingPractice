public class ConvertSortedArraytoBinarySearchTree {
    static public TreeNode sortedArrayToBST(int[] num) {
        return helper(num, 0, num.length - 1);
    }

    static public TreeNode helper(int [] num, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = helper(num, start, mid-1);
        root.right = helper(num, mid+1, end);

        return root;
    }

    public static void main(String [ ] args) {
        System.out.println(sortedArrayToBST(new int[]{2, 4, 5, 6, 10}).val);
    }
}
