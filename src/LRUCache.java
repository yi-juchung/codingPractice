import java.util.HashMap;

public class LRUCache {
    HashMap<Integer,DDL> cache;
    DDL root;
    DDL tail;
    int num;
    int max;

    class DDL {
        int val;
        int key;
        DDL next;
        DDL prev;

        DDL(int keyInput, int valInput) {
            val = valInput;
            key = keyInput;
        }
    }

    public LRUCache(int capacity) {
        cache = new HashMap<Integer, DDL>(capacity);
        root = new DDL(-1, -1);
        tail = root;
        num = 0;
        max = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DDL cur = cache.get(key);
            moveToFront(cur);
            return cur.val;
        } else {
            return -1;
        }
    }

    public void moveToFront(DDL cur) {
        if (cur == tail && cur.prev != root) {
            tail = cur.prev;
        }

        cur.prev.next = cur.next;
        if (cur.next != null) {
            cur.next.prev = cur.prev;
        }

        cur.next = root.next;
        cur.prev = root;
        if (root.next != null) {
            root.next.prev = cur;
        }
        root.next = cur;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            DDL cur = cache.get(key);
            moveToFront(cur);
            cur.val = value;
        } else {
            DDL cur = new DDL(key,value);
            cur.next = root.next;
            if (root.next != null) {
                root.next.prev = cur;
            } else {
                tail = cur;
            }

            root.next = cur;
            cur.prev = root;

            if (num < max) {
                num++;
            } else {
                if (tail != cur) {
                    cache.remove(tail.key);
                    tail = tail.prev;
                }
            }

            cache.put(key,cur);
        }
    }

    public static void main(String [ ] args) {
        // 2,-1
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2, 1);
        lruCache.set(2,2);
        System.out.println(lruCache.get(2));
        lruCache.set(1, 1);
        lruCache.set(4,1);
        System.out.println(lruCache.get(2));
    }
}
