import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergekSortedLists {
    static public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;

        Queue<ListNode> queue = new PriorityQueue<ListNode>((lists.length==0)?1:lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        for (ListNode ln : lists) {
            if (ln != null)
                queue.add(ln);
        }

        while (!queue.isEmpty()) {
            ListNode ln = queue.poll();

            cur.next = ln;
            if (ln.next != null)
                queue.add(ln.next);

            cur = cur.next;
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

        ListNode [] input = new ListNode[]{ln1,ln2};

        ListNode res = mergeKLists(input);

        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
