public class ReorderList {
    static public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = head;
        ListNode preMid = null;
        ListNode end = head;

        while (end != null && end.next != null) {
            preMid = mid;
            mid = mid.next;
            end = end.next.next;
        }

        preMid.next = null;

        ListNode curNode = mid;
        ListNode realNext = null;
        while (curNode != null) {
            ListNode prevNext = curNode.next;
            curNode.next = realNext;
            realNext = curNode;
            curNode = prevNext;
        }

        mid = head;
        ListNode tail = null;
        while (mid != null) {
            ListNode nextNode = mid.next;
            mid.next = realNext;
            realNext = realNext.next;
            mid.next.next = nextNode;
            tail = mid.next;
            mid = nextNode;
        }

        if (realNext != null) {
            tail.next = realNext;
        }
    }

    public static void main(String [ ] args) {
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(2);
        ln1.next.next = new ListNode(3);
        ln1.next.next.next = new ListNode(4);
        ln1.next.next.next.next = new ListNode(5);

        reorderList(ln1);

        while(ln1 != null) {
            System.out.println(ln1.val);
            ln1 = ln1.next;
        }
    }
}
