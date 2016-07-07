import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MeetingRoomsII {
    static class Event {
        int time;
        boolean start;

        public Event(int t, boolean s) {
            time =t; start = s;
        };
    }

    static public int minMeetingRooms(Interval[] intervals) {
        List<Event> events = new LinkedList<>();

        for (Interval i : intervals) {
            events.add(new Event(i.start,true));
            events.add(new Event(i.end,false));
        }

        Collections.sort(events, new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.time-o2.time;
            }
        });

        int count = 0;
        boolean prevType = false;

        for (Event e : events) {
            if (prevType == e.start) {
                count++;
            } else {
                prevType = e.start;
            }
        }

        return count;
    }

    public static void main(String [ ] args) {
        Interval [] ints = new Interval[] {
                new Interval(0,30),
                new Interval(5,10),
                new Interval(15,20)
        };

        // 2
        System.out.println(minMeetingRooms(ints));
    }
}
