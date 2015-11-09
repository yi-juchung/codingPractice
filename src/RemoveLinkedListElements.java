public class RemoveLinkedListElements {
    static public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode cur = head;
        ListNode prev = newHead;

        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }

            cur = cur.next;
        }

        return newHead.next;
    }

    public static void main(String [ ] args) {
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(2);
        ln1.next.next = new ListNode(3);
        ln1.next.next.next = new ListNode(2);
        ln1.next.next.next.next = new ListNode(5);

        ListNode newHead = removeElements(ln1,2);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
