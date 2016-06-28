import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    static public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> counts = new HashMap<>();

        for (int i : nums) {
            counts.put(i, (counts.containsKey(i))?counts.get(i)+1:1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });

        for (Map.Entry<Integer,Integer> e : counts.entrySet()) {

            if (pq.size() == k && (pq.peek().getValue() < e.getValue())) {
                pq.poll();
                pq.add(e);
            } else if (pq.size() < k) {
                pq.add(e);
            }
        }

        List<Integer> res = new ArrayList<>(k);
        while (!pq.isEmpty())
            res.add(pq.poll().getKey());

        return res;
    }

    // bucket sort

    public static void main(String [ ] args) {
        int [] nums = new int []{1,1,1,2,2,3};

        System.out.println(topKFrequent(nums,2));
    }
}
