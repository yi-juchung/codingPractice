import java.util.List;

public class MergeTwoLists {
    static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
            cur.next = null;
        }

        if (l1 != null) {
            cur.next = l1;
        }

        if (l2 != null) {
            cur.next = l2;
        }

        return res.next;
    }

    public static void main(String [ ] args) {
        ListNode ln1 = new ListNode(3);
        ListNode ln2 = new ListNode(5);

        ln1.next = new ListNode(6);
        ln1.next.next = new ListNode(9);
        ln1.next.next.next = new ListNode(10);

        ln2.next = new ListNode(7);
        ln2.next.next = new ListNode(11);

        ListNode res = mergeTwoLists(ln1,ln2);

        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
