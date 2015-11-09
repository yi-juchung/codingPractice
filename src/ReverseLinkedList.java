public class ReverseLinkedList {

    static public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = null;

        ListNode newHead = reverseList(next);
        next.next = head;

        return newHead;
    }

    public static void main(String [ ] args) {
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(2);
        ln1.next.next = new ListNode(3);
        ln1.next.next.next = new ListNode(4);
        ln1.next.next.next.next = new ListNode(5);

        ListNode rev = reverseList(ln1);

        while (rev != null) {
            System.out.print(rev.val+"-");
            rev = rev.next;
        }
    }
}
