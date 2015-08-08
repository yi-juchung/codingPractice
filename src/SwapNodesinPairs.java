public class SwapNodesinPairs {
    static  ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;

        ListNode next = head.next;
        ListNode nextnext = null;

        if (next != null) {
            nextnext = next.next;

            next.next = head;
            head.next = swapPairs(nextnext);
        } else {
            return head;
        }

        return next;
    }

    public static void main(String [ ] args) {
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(2);
        ln1.next.next = new ListNode(3);
        ln1.next.next.next = new ListNode(4);
        ln1.next.next.next.next = new ListNode(5);

        ln1 = swapPairs(ln1);

        while(ln1 != null) {
            System.out.println(ln1.val);
            ln1 = ln1.next;
        }
    }
}
