public class GetIntersectionNode {
    static public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode lastNodeA = headA;

        while(lastNodeA.next != null) {
            lastNodeA = lastNodeA.next;
        }

        lastNodeA.next = headB;

        ListNode curNode = headA;
        ListNode secFastNode = headA;

        while(secFastNode != null && secFastNode.next != null) {
            secFastNode = secFastNode.next.next;
            curNode = curNode.next;

            if (curNode == secFastNode)
                break;
        }

        if (secFastNode != null && curNode == secFastNode) {
            while (headA != curNode) {
                headA = headA.next;
                curNode = curNode.next;
            }

            lastNodeA.next = null;
            return curNode;
        } else {
            lastNodeA.next = null;
            return null;
        }
    }

    public static void main(String [ ] args) {
        ListNode headA = new ListNode(1);
//        headA.next = new ListNode(2);
//        headA.next.next = new ListNode(3);
//        headA.next.next.next = new ListNode(6);
//        headA.next.next.next.next = new ListNode(7);
        headA.next = new ListNode(3);
        headA.next.next = new ListNode(5);
        headA.next.next.next = new ListNode(7);
        headA.next.next.next.next = new ListNode(9);

        ListNode headB = new ListNode(2);
//        headB.next = new ListNode(5);
//        headB.next.next = headA.next.next;

        ListNode inter = getIntersectionNode(headA, headB);

        while (inter != null) {
            System.out.println(inter.val);
            inter = inter.next;
        }
    }
}
