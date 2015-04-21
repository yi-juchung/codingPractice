public class ConstructBinaryTreefromInorderandPostorderTraversal {
    static public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length < 1 || inorder.length != postorder.length)
            return null;
        int num = inorder.length;
        return helper(inorder,postorder,0,num-1,0,num-1);
    }

    static public TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd,
                                  int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int spiltIdx = inStart;
        for (;spiltIdx <= inEnd;spiltIdx++) {
            if (inorder[spiltIdx] == rootVal) {
                break;
            }
        }

        root.left = helper(inorder,postorder,inStart, spiltIdx-1, postStart, postStart+(spiltIdx-inStart)-1);
        root.right = helper(inorder,postorder,spiltIdx+1, inEnd, postStart+(spiltIdx-inStart), postEnd-1);

        return root;
    }

    public static void main(String [ ] args) {
        TreeNode root = buildTree(new int[]{4,2,5,7,1,6,3},
                new int[]{4,7,5,2,6,3,1});
        System.out.println(root.val);
    }
}
