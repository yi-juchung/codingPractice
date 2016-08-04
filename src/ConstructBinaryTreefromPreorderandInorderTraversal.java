public class ConstructBinaryTreefromPreorderandInorderTraversal {
    static public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    static public TreeNode helper (int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps > pe) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[ps]);

        int split = -1;
        for (int i=is;i<=ie;i++) {
            if (inorder[i] == root.val) {
                split = i;
                break;
            }
        }

        root.left = helper(preorder,inorder,ps+1,ps+(split-is),is,split-1);
        root.right = helper(preorder,inorder,ps+(split-is)+1,pe,split+1,ie);
        return root;
    }

    public static void main(String [ ] args) {
        TreeNode root = buildTree(new int[]{4,2,5,7,1,6,3},
                new int[]{5,2,7,4,6,1,3});

        System.out.println(BinaryTreeSerialization.serialize(root));
    }
}
