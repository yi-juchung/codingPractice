import java.util.HashMap;

public class ZigzacLinkedList {

    public static ListNode zigzac(ListNode root) {
        HashMap<ListNode, ListNode> parents = new HashMap<ListNode, ListNode>();

        ListNode cur = root;
        ListNode par = null;
        while (cur != null) {
            parents.put(cur,par);
            par = cur;
            cur = cur.next;
        }

        cur = root;
        ListNode res = new ListNode(-1);
        ListNode newHead = res;

        while ( cur != par ) {
            res.next = cur;
            cur = cur.next;
            res = res.next;

            res.next = par;
            par = parents.get(par);
            res = res.next;

            if (cur.next == par) {
                break;
            }
        }

        if (cur == par) {
            res.next = cur;
            res.next.next = null;
        } else {
            res.next = null;
        }

        return newHead.next;
    }

    public static void main(String [ ] args) {
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(2);
        ln1.next.next = new ListNode(3);
        ln1.next.next.next = new ListNode(4);
        ln1.next.next.next.next = new ListNode(5);

        ListNode rev = zigzac(ln1);

        while (rev != null) {
            System.out.print(rev.val+"-");
            rev = rev.next;
        }
    }
}
