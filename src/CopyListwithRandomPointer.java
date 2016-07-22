import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {
    static public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode,RandomListNode> cloned = new HashMap<>();

        RandomListNode cloneHead = new RandomListNode(-1);
        RandomListNode clone = cloneHead;
        RandomListNode cur = head;

        while (cur != null) {
            RandomListNode newrln = new RandomListNode(cur.label);

            if (cur.next != null) {
                if (!cloned.containsKey(cur.next)) {
                    cloned.put(cur.next, new RandomListNode(cur.next.label));
                }

                newrln.next = cloned.get(cur.next);
            } else {
                newrln.next = null;
            }

            if (cur.random != null) {
                if (!cloned.containsKey(cur.random)) {
                    cloned.put(cur.random, new RandomListNode(cur.random.label));
                }

                newrln.random = cloned.get(cur.random);
            } else {
                newrln.random = null;
            }

            clone.next = newrln;
            clone = clone.next;
            cur = cur.next;
        }

        return cloneHead.next;
    }

    public static void main(String [ ] args) {

        RandomListNode randomListNode = new RandomListNode(1);

        RandomListNode cur = randomListNode;
        while (cur != null) {
            System.out.println(cur.label);
            cur = cur.next;
        }

        RandomListNode clone = copyRandomList(randomListNode);

        while (clone != null) {
            System.out.println(clone.label);
            clone = clone.next;
        }
    }
}
