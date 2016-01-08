public class PalindromeLinkedList {
    static public boolean isPalindrome(ListNode head) {
        ListNode lnMid = head;
        ListNode lnEnd = head;
        int count = 0;

        while (lnEnd != null && lnEnd.next != null) {
            lnMid = lnMid.next;
            lnEnd = lnEnd.next.next;
            count += 2;
        }

        if (lnEnd != null)
            count++;

        if (count%2 == 1) {
            lnMid = lnMid.next;
        }

        ListNode cur = lnMid;
        ListNode prev = null;

        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        count /= 2;

        while (count != 0 || prev != null) {
            if (prev.val != head.val) {
                return false;
            } else {
                prev = prev.next;
                head = head.next;
                count--;
            }
        }

        return true;
    }

    public static void main(String [ ] args) {
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(2);
        ln1.next.next = new ListNode(3);
        ln1.next.next.next = new ListNode(2);
        ln1.next.next.next.next = new ListNode(2);

        //ln1.next.next.next.next.next = ln1.next.next;

        System.out.println(isPalindrome(ln1));
    }
}
