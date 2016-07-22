public class PartitionList {
    static public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode curSmall = small;
        ListNode curLarge = large;

        while (head != null) {
            if (head.val < x) {
                curSmall.next = head;
                curSmall = curSmall.next;
                head = head.next;
                curSmall.next = null;
            } else {
                curLarge.next = head;
                curLarge = curLarge.next;
                head = head.next;
                curLarge.next = null;
            }
        }

        curSmall.next = large.next;
        return small.next;
    }

    public static void main(String [ ] args) {
        ListNode ln = new ListNode(1);

        ln.next = new ListNode(4);
        ln.next.next = new ListNode(3);
        ln.next.next.next = new ListNode(2);
        ln.next.next.next.next = new ListNode(5);
        ln.next.next.next.next.next = new ListNode(2);

        ln = partition(ln, 3);

        // 1->2->2->4->3->5
        while (ln != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }
}
