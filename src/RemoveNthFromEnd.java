public class RemoveNthFromEnd {
    static public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode curNode = dummyNode;
        ListNode fastNode = head;

        for (int i=0;i<n;i++) {
            fastNode = fastNode.next;
        }

        while(fastNode != null) {
            fastNode = fastNode.next;
            curNode = curNode.next;
        }

        curNode.next = curNode.next.next;

        return dummyNode.next;
    }

    public static void main(String [ ] args) {
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(2);
//        ln1.next.next = new ListNode(3);
//        ln1.next.next.next = new ListNode(4);
//        ln1.next.next.next.next = new ListNode(5);

        ListNode res = removeNthFromEnd(ln1, 2);

        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
