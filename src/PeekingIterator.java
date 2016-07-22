import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekingIterator {
    static public class PI implements Iterator<Integer> {
        Integer next = null;
        Iterator<Integer> iter = null;

        public PI(Iterator<Integer> iterator) {
            // initialize any member here.
            if (iterator.hasNext()) {
                next = iterator.next();
            }

            iter = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (next != null) {
                int curNext = next;
                if (iter.hasNext()) {
                    next = iter.next();
                } else {
                    next = null;
                }
                return curNext;
            } else {
                return null;
            }
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }
    }

    public static void main(String [ ] args) {
        PI p = new PI(Arrays.asList(1,2,3).iterator());

        // 1,2,2,3,false
        System.out.println(p.next());
        System.out.println(p.peek());
        System.out.println(p.next());
        System.out.println(p.next());
        System.out.println(p.hasNext());
    }
}
