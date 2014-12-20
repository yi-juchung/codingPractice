public class InsertionSortList {
    static public ListNode insertionSortList(ListNode head) {

    }

    public static void main(String [ ] args) {
        ListNode ln1 = new ListNode(5);
        ln1.next = new ListNode(2);
        ln1.next.next = new ListNode(1);
        ln1.next.next.next = new ListNode(4);
        ln1.next.next.next.next = new ListNode(3);

        ListNode res = insertionSortList(ln1);

        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
