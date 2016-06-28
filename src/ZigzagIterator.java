import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ZigzagIterator {

    static public class ZZ {

        Iterator<Integer> it1;
        Iterator<Integer> it2;
        int turns;

        public ZZ(List<Integer> v1, List<Integer> v2) {
            it1 = v1.iterator();
            it2 = v2.iterator();
            turns = 0;
        }

        public int next() {
            if (turns == 0) {
                if (it1.hasNext()) {
                    turns = 1;
                    return it1.next();
                } else {
                    return (it2.hasNext())?it2.next():0;
                }
            } else {
                if (it2.hasNext()) {
                    turns = 0;
                    return it2.next();
                } else {
                    return (it1.hasNext())?it1.next():0;
                }
            }
        }

        public boolean hasNext() {
            return this.it1.hasNext() || this.it2.hasNext();
        }
    }

    static public class ZZFP {

        List<Iterator<Integer>> itlist;
        int idx = 0;
        public ZZFP(List<Iterator<Integer>> list) {
            itlist = new LinkedList<>();

            for (Iterator<Integer> l : list) {
                if (l.hasNext()) itlist.add(l);
            }
        }

        public int next() {
            if (!hasNext()) {
                return 0;
            }

            int res = itlist.get(idx).next();
            if (!itlist.get(idx).hasNext()) {
                itlist.remove(idx);
                idx--;
            }

            idx++;

            if (itlist.size() > 0) {
                idx = idx%itlist.size();
            }

            return res;
        }

        public boolean hasNext() {
            return !itlist.isEmpty();
        }
    }


    public static void main(String [ ] args) {

        ZZ zz = new ZZ(Arrays.asList(1,2),Arrays.asList(3,4,5,6));

        while(zz.hasNext()) {
            System.out.println(zz.next());
        }

        List<Iterator<Integer>> iterators = new LinkedList<>();
        iterators.add(Arrays.asList(1,2,3).iterator());
        iterators.add(Arrays.asList(4,5,6,7).iterator());
        iterators.add(Arrays.asList(8,9).iterator());
        ZZFP zzfp = new ZZFP(iterators);

        while(zzfp.hasNext()) {
            System.out.println(zzfp.next());
        }
    }
}
