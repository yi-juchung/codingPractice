import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class CoolingTime {
    static public int countCoolTime (int [] times, int cool) {
        Map<Integer,Integer> cooling = new HashMap<>();

        int total = 0;
        for (int i=0;i<times.length;i++) {
            if (cooling.containsKey(times[i])) {
                int lastTime = cooling.get(times[i]);

                if (i-lastTime >= cool) {
                    total += i-lastTime+1;
                }
            }

            cooling.put(times[i],i);
        }

        return total+times.length;
    }

    static class Job {
        int time;
        int val;
        int count;

        public Job (int t, int v) {
            time = t;
            val = v;
            count = 0;
        }
    }

    static public int shortestCoolingTime (int [] times, int cool) {
        Map<Integer,Job> jobMap = new HashMap<>();
        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.count == o2.count) {
                    return o2.time-o1.time;
                } else
                    return o2.count-o1.count;
            }
        });

        for (int i : times) {
            Job j = jobMap.containsKey(i)?jobMap.get(i):new Job(-3,i);
            j.count++;
            jobMap.put(i,j);
        }

        for (Job j : jobMap.values()) {
            pq.add(j);
        }

        int curT = 0;
        while (!pq.isEmpty()) {
            List<Job> cand = new LinkedList<>();

            Job j = pq.poll();
            while (curT-j.time <= cool && !pq.isEmpty()) {
                cand.add(j);
                j = pq.poll();
            }

            if (curT-j.time > cool) {
                j.count--;
                j.time = curT;
                if (j.count > 0) {
                    cand.add(j);
                }
            }

            curT++;
            pq.addAll(cand);
        }

        return curT+1;
    }

    public static void main(String [ ] args) {
        int [] times = new int []{1,2,1,1,3,4};
        System.out.println(shortestCoolingTime(times, 2));

        times = new int []{1,1,1};
        System.out.println(countCoolTime(times, 2));

        times = new int []{1,1,2,2,3,3};
        System.out.println(countCoolTime(times, 2));
    }
}
