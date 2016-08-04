import java.util.Stack;

public class ReverseLinkedList {

    static public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = null;

        ListNode last = reverseList(next);
        next.next = head;
        return last;
    }

    static public ListNode reverseListIterate(ListNode head) {
        ListNode ln = head;
        Stack<ListNode> stack = new Stack<>();

        while (ln.next != null) {
            stack.push(ln);
            ln = ln.next;
        }

        ListNode newHead = ln;

        while (!stack.isEmpty()) {
            ln.next = stack.pop();
            ln = ln.next;
            ln.next = null;
        }

        return newHead;
    }

    static public ListNode reverseListIterate2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            // lock cur
            next = cur.next;
            // lock prev
            cur.next = prev;
            // unlock prev
            // unlock cur
            prev = cur;
            cur = next;
        }

        head = prev;

        return head;
    }

    public static void main(String [ ] args) {
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(2);
        ln1.next.next = new ListNode(3);
        ln1.next.next.next = new ListNode(4);
        ln1.next.next.next.next = new ListNode(5);

        ListNode rev = reverseListIterate2(ln1);

        while (rev != null) {
            System.out.print(rev.val+"-");
            rev = rev.next;
        }
    }
}
