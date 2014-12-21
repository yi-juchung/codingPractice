public class InsertionSortList {
    static public ListNode insertionSortList(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode curNode = head;
        ListNode preCurNode = preHead;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            ListNode preNextNode = curNode;

            while(nextNode != null) {
                if (nextNode.val < curNode.val) {
                    swap(preCurNode, curNode, preNextNode, nextNode);

                    ListNode temp = curNode;
                    curNode = nextNode;
                    nextNode = temp;
                }
                preNextNode = nextNode;
                nextNode = nextNode.next;
            }

            preCurNode = curNode;
            curNode = curNode.next;
        }

        return preHead.next;
    }

    static public void swap(ListNode preOri, ListNode ori, ListNode preTar, ListNode tar) {
        preOri.next = tar;
        preTar.next = ori;
        ListNode tempNext = tar.next;
        tar.next = ori.next;
        ori.next = tempNext;
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
