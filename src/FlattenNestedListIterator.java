import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator {
    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        Stack<NestedInteger> inner = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (int i=nestedList.size()-1;i>=0;i--) {
                inner.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            Integer res = null;

            while (hasNext()) {
                NestedInteger ni = inner.pop();

                if (ni.isInteger()) {
                    res = ni.getInteger();
                    break;
                } else {
                    for (int i=ni.getList().size()-1;i>=0;i--) {
                        inner.push(ni.getList().get(i));
                    }
                }
            }

            return res;
        }

        @Override
        public boolean hasNext() {
            boolean hasNext = false;
            while (!inner.isEmpty()) {
                NestedInteger ni = inner.pop();

                if (ni.isInteger()) {
                    hasNext = true;
                    inner.push(ni);
                    break;
                } else {
                    for (int i=ni.getList().size()-1;i>=0;i--) {
                        inner.push(ni.getList().get(i));
                    }
                }
            }

            return hasNext;
        }
    }
}
