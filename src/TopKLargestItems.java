import java.util.PriorityQueue;

public class TopKLargestItems {
    static public Integer [] topk (int [] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : input) {
            if (pq.size() == k && pq.peek() < i) {
                pq.poll();
                pq.add(i);
            } else if (pq.size() < k) {
                pq.add(i);
            }
        }
        Integer [] res = new Integer[pq.size()];
        return pq.toArray(res);
    }

    public static void main(String [ ] args) {
        int [] nums = new int [] {5,6,2,100,8};
        for (int i: topk(nums,2)) {
            System.out.println(i);
        }
    }
}
