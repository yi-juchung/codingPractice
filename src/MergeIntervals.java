import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    static public List<Interval> merge(List<Interval> intervals) {
        List<Interval> pairs = new ArrayList<>();
        List<Interval> res = new LinkedList<>();

        if (intervals.size() < 1)
            return res;

        for (Interval i : intervals) {
            pairs.add(new Interval(i.start, 0));
            pairs.add(new Interval(i.end, 1));
        }

        Collections.sort(pairs, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end-o2.end;
                } else {
                    return o1.start-o2.start;
                }
            }
        });


        int count = 0;
        Interval cand = new Interval(0,0);
        for (Interval p : pairs) {
            if (p.end == 0) {
                if (count == 0) {
                    if (cand.end != p.start)
                        cand = new Interval(p.start,0);
                }
                count++;
            } else {
                if (count == 1) {
                    cand.end = p.start;
                    res.add(cand);
                }
                count--;
            }
        }

        return res;
    }

    public static void main(String [ ] args) {
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));

        for (Interval i : merge(intervals)) {
            System.out.println(i.start+":"+i.end);
        }

        intervals = new LinkedList<>();
        intervals.add(new Interval(1,5));
        intervals.add(new Interval(5,8));

        for (Interval i : merge(intervals)) {
            System.out.println(i.start+":"+i.end);
        }
    }
}
