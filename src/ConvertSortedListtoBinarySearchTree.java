public class ConvertSortedListtoBinarySearchTree {
    static public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = null;

        if (head != null) {
            ListNode mid = findMid(head);
            root = new TreeNode(mid.val);
            if (mid.next != null)
                root.right = sortedListToBST(mid.next);
            mid.next = null;
            if (mid != head)
                root.left = sortedListToBST(head);
        }

        return root;
    }

    static public ListNode findMid(ListNode start) {
        ListNode slow = start;
        ListNode fast = start;

        ListNode prev = slow;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        return slow;
    }

    public static void main(String [ ] args) {
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(2);
        ln1.next.next = new ListNode(3);
        ln1.next.next.next = new ListNode(4);
        ln1.next.next.next.next = new ListNode(5);

        System.out.println(sortedListToBST(ln1).val);
    }
}
