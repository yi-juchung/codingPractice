public class ReverseLinkedListII {
    static public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        ListNode beforeRev = fakeHead;

        int dif = n-m+1;
        while (m > 1) {
            beforeRev = beforeRev.next;
            m--;
        }

        ListNode prev = null;
        ListNode revLast = beforeRev.next;
        ListNode cur = revLast;
        ListNode next = cur.next;
        for (int i = 0;i < dif;i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        beforeRev.next = prev;
        revLast.next = next;

        return fakeHead.next;
    }

    public static void main(String [ ] args) {
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(2);
        ln1.next.next = new ListNode(3);
        ln1.next.next.next = new ListNode(4);
        ln1.next.next.next.next = new ListNode(5);

        ListNode rev = reverseBetween(ln1, 3, 5);

        while (rev != null) {
            System.out.print(rev.val+"-");
            rev = rev.next;
        }
    }
}
