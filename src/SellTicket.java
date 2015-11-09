import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class SellTicket {

    public static int maxProfit(int [] first, int [] second) {
        int n = first[0];
        int m = first[1];

        if (n == 1) {
            int res = 0;
            for (int i=0;i<m;i++) {
                res += second[0]--;
            }

            return res;
        }

        List<Integer> input = new LinkedList<Integer>();
        int edge = Math.min(second.length,m);
        for (int i=0;i<edge;i++) {
            input.add(second[i]);
        }

        Collections.sort(input, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        int prev = input.get(0);
        int numTickets = 0;
        int idx = 1;
        int profit = 0;

        while(idx < n) {
            int cur = input.get(idx);
            int nextTicket = numTickets+(prev-cur)*idx;

            if (nextTicket >= m) {
                break;
            }

            numTickets = nextTicket;
            profit += (prev+cur+1)*(prev-cur)*idx/2;
            prev = cur;
            idx++;
        }

        while (numTickets < m) {
            int numTicketThisBatch = Math.min(idx,m-numTickets);
            profit += numTicketThisBatch*prev--;
            numTickets += numTicketThisBatch;
        }

        return profit;
    }

//    public static int maxProfit(int [] first, int [] second) {
//        int n = first[0];
//        int m = first[1];
//
//        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//
//        for (int i : second) {
//            heap.add(i);
//        }
//
//        int max = 0;
//        for (int i=0;i<m;i++) {
//            if (heap.isEmpty()) {
//                break;
//            }
//
//            int top = heap.poll();
//            max += top;
//
//            if (top != 0)
//                heap.add(top-1);
//        }
//
//        return max;
//    }

    public static void main(String [ ] args) {

        int [] first = new int[]{2,4};
        int [] second = new int[]{2,5};

        System.out.println(maxProfit(first,second));
    }
}
