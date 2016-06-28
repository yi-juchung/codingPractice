public class OddEvenLinkedList {
    static public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        ListNode evenHead = null;
        ListNode even = null;

        while (cur != null && cur.next != null) {
            if (even == null) {
                even = cur.next;
                evenHead = even;
            } else {
                even.next = cur.next;
                even = even.next;
            }
            cur.next = cur.next.next;

            if (cur.next == null) {
                break;
            }

            cur = cur.next;
        }

        cur.next = evenHead;

        return head;
    }

    public static void main(String [ ] args) {
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(2);
        ln1.next.next = new ListNode(3);
        ln1.next.next.next = new ListNode(4);
        ln1.next.next.next.next = new ListNode(5);
        ln1.next.next.next.next.next = new ListNode(6);

        ListNode newHead = oddEvenList(ln1);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
