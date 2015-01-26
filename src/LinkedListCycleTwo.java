public class LinkedListCycleTwo {

    static public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            slow = head;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }

        return null;
    }

    public static void main(String [ ] args) {
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(2);
        //ln1.next.next = new ListNode(3);
        //ln1.next.next.next = new ListNode(4);
        //ln1.next.next.next.next = new ListNode(5);

        ln1.next.next.next.next.next = ln1.next.next;

        ListNode meet = detectCycle(ln1);
        if (meet != null) {
            System.out.print(meet.val);
        } else {
            System.out.print("null");
        }
    }
}
