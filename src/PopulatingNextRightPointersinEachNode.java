public class PopulatingNextRightPointersinEachNode {
    static public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            if (root.next != null)
                root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }

    public static void main(String [ ] args) {
        TreeLinkNode root = new TreeLinkNode(1);

        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);

        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        connect(root);

        TreeLinkNode next = root.left;
        System.out.println(root.val);

        while (next != null) {
            TreeLinkNode cur = next;
            next = cur.left;

            while (cur != null) {
                System.out.print(cur.val+"-");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}
