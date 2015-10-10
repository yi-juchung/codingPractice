import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class GetPutTime {
    HashMap<Integer, TreeSet<Pair<Integer,Integer>>> values;

    GetPutTime() {
        values = new HashMap<Integer, TreeSet<Pair<Integer,Integer>>>();
    }

    int getTime (int key, int time) {
        if (values.containsKey(key)) {
            TreeSet<Pair<Integer,Integer>> times = values.get(key);
            List<Pair<Integer,Integer>> listTimes = new ArrayList<Pair<Integer, Integer>>(times);
            Pair<Integer,Integer> cand = getValueAndTime(listTimes, time);

            if (cand != null)
                return cand.getValue();
        }

        return -1;
    }

    void putTime (int key, int value, int time) {
        TreeSet<Pair<Integer,Integer>> times;
        if (values.containsKey(key)) {
            times = values.get(key);
            times.add(new Pair<Integer, Integer>(time,value));
            values.put(key, times);
        } else {
            times = new TreeSet<Pair<Integer, Integer>>(new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                    return o1.getKey()-o2.getKey();
                }
            });
            times.add(new Pair<Integer, Integer>(time,value));
            values.put(key, times);
        }
    }

    Pair<Integer,Integer> getValueAndTime(List<Pair<Integer,Integer>> pairs, int time) {
        int start = 0;
        int end = pairs.size()-1;
        Pair<Integer,Integer> res = null;

        while (start <= end) {
            int mid = start+(end-start)/2;

            Pair<Integer,Integer> cand = pairs.get(mid);
            if (cand.getKey() < time) {
                if (res == null) {
                    res = cand;
                } else if (res.getKey() < cand.getKey()) {
                    res = cand;
                }
                start = mid+1;
            } else if (cand.getKey() == time) {
                return cand;
            } else {
                end = mid-1;
            }
        }

        return res;
    }

    public static void main(String [ ] args) {
        GetPutTime m = new GetPutTime();
        m.putTime(3, 1, 5);
        m.putTime(3, 2, 7);
        m.putTime(3, 3, 9);
        m.putTime(3, 4, 11);
        m.putTime(3, 5, 13);

        System.out.println(m.getTime(3, 8));
        System.out.println(m.getTime(3, 11));
        System.out.println(m.getTime(3, 4));
    }
}
