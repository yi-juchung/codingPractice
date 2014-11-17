public class DeleteDuplicates {

    static public ListNode deleteDuplicates(ListNode head) {

        ListNode anchorNode = head;

        while (anchorNode != null) {
            ListNode curNode = anchorNode.next;

            while (curNode != null && anchorNode.val == curNode.val) {
                curNode = curNode.next;
            }

            anchorNode.next = curNode;
            anchorNode = curNode;
        }

        return head;
    }

    public static void main(String [ ] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);

        deleteDuplicates(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
