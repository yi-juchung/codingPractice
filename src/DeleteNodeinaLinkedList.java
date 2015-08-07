public class DeleteNodeinaLinkedList {
    static public void deleteNode(ListNode node) {
        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public static void main(String [ ] args) {
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(2);
        ln1.next.next = new ListNode(3);
        ln1.next.next.next = new ListNode(4);
        ln1.next.next.next.next = new ListNode(5);

        deleteNode(ln1.next.next.next);
        while(ln1 != null) {
            System.out.println(ln1.val);
            ln1 = ln1.next;
        }
    }
}
