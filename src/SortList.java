public class SortList {
    static public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next = null;

        return merge(sortList(head), sortList(right));
    }

    static public ListNode merge(ListNode lnLeft, ListNode lnRight) {
        ListNode ln = new ListNode(0);
        ListNode head = ln;

        while (lnLeft != null && lnRight != null) {
            if (lnLeft.val < lnRight.val) {
                ln.next = lnLeft;
                lnLeft = lnLeft.next;
            } else {
                ln.next = lnRight;
                lnRight = lnRight.next;
            }

            ln = ln.next;
        }

        if (lnLeft != null) {
            ln.next = lnLeft;
        }

        if (lnRight != null) {
            ln.next = lnRight;
        }

        return head.next;
    }

    static public ListNode findMid(ListNode head) {
        if (head == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String [ ] args) {
        ListNode ln1 = new ListNode(5);
        ln1.next = new ListNode(2);
        ln1.next.next = new ListNode(1);
        ln1.next.next.next = new ListNode(4);
        ln1.next.next.next.next = new ListNode(3);

        ListNode res = sortList(ln1);

        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
