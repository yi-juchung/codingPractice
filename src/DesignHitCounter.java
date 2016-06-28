import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DesignHitCounter {

    static public class HitCounter {
        int [] counts;
        int [] times;

        public HitCounter() {
            counts = new int [300];
            times = new int [300];
        }

        public void hit (int time) {
            if (times[time%300] == time) {
                counts[time%300]++;
            } else {
                counts[time%300] = 1;
                times[time%300] = time;
            }
        }

        public int getHits (int time) {
            int total = 0;

            for (int i=0;i<300;i++) {
                if (time-times[i] < 300) {
                    total += counts[i];
                }
            }

            return total;
        }
    }

//    static public class HitCounter {
//        Queue<Integer> times;
//
//        public HitCounter() {
//            times = new LinkedList<>();
//        }
//
//        public void hit (int time) {
//            times.add(time);
//        }
//
//        public int getHits (int time) {
//            while(!times.isEmpty()) {
//                int t = times.peek();
//                if (t+300 > time) {
//                    break;
//                } else {
//                    times.poll();
//                }
//
//
//            }
//
//            return times.size();
//        }
//    }

//    static public class HitCounter {
//        public class hit {
//            int time;
//            int hit;
//
//            public hit(int t, int h) {
//                time = t;
//                hit = h;
//            }
//        }
//
//        Deque<hit> deque;
//
//        public HitCounter() {
//            deque = new LinkedList<>();
//        }
//
//        public void hit (int time) {
//            if (!deque.isEmpty() && deque.peekFirst().time == time) {
//                deque.peekFirst().hit++;
//            } else {
//                deque.add(new hit(time,1));
//            }
//
//            while (!deque.isEmpty()) {
//                if (time-deque.peekLast().time > 300) {
//                    deque.pollLast();
//                } else {
//                    break;
//                }
//            }
//        }
//
//        public int getHits (int time) {
//            int total = 0;
//            Iterator<hit> hi = deque.iterator();
//            while (hi.hasNext()) {
//                hit h = hi.next();
//                if (h.time+300 > time) {
//                    total += h.hit;
//                }
//            }
//
//            return total;
//        }
//    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();

        // hit at timestamp 1.
        counter.hit(1);

        // hit at timestamp 2.
        counter.hit(2);

        // hit at timestamp 3.
        counter.hit(3);

        // get hits at timestamp 4, should return 3.
        System.out.println(counter.getHits(4));

        // hit at timestamp 300.
        counter.hit(300);

        // get hits at timestamp 300, should return 4.
        System.out.println(counter.getHits(300));

        // get hits at timestamp 301, should return 3.
        System.out.println(counter.getHits(301));
    }
}
