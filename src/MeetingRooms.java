import javafx.util.Pair;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MeetingRooms {

    static class Time {
        int t;
        boolean start;

        public Time(int a, boolean b) {
            t = a;
            start = b;
        }
    }

    static public boolean attend(List<Pair> input) {
        List<Time> times = new LinkedList<>();

        for (Pair p : input) {
            times.add(new Time((int)p.getKey(),true));
            times.add(new Time((int)p.getValue(),false));
        }

        times.sort(new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                return o1.t-o2.t;
            }
        });
        boolean b = false;
        for (Time t : times) {
            if (b == t.start) {
                return false;
            }
            b = t.start;
        }

        return true;
    }

    public static void main(String [ ] args) {
        List<Pair> input = new LinkedList<>();

        input.add(new Pair(0,30));
        input.add(new Pair(5,10));
        input.add(new Pair(15,20));

        System.out.print(attend(input));
    }
}
