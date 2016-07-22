import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    static public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 1 || nums.length < k)
            return new int[0];

        int [] res = new int [nums.length-k+1];
        int ri = 0;

        Deque<Integer> deque = new LinkedList<>();
        for (int i=0;i<nums.length;i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i-k+1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);
            if (i>=k-1) {
                res[ri++] = nums[deque.peekFirst()];
            }
        }

        return res;
    }

    static public int[] minSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 1 || nums.length < k)
            return new int[0];

        int [] res = new int [nums.length-k+1];
        int ri = 0;

        Deque<Integer> deque = new LinkedList<>();
        for (int i=0;i<nums.length;i++) {
            while ( !deque.isEmpty() && deque.peekFirst() < i-k+1 ) {
                deque.pollFirst();
            }

            while ( !deque.isEmpty() && nums[deque.peekLast()] > nums[i] ) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k-1) {
                res[ri++] = nums[deque.peekFirst()];
            }
        }

        return res;
    }

    public static void main(String [ ] args) {
        int [] nums = new int []{1,3,-1,-3,5,3,6,7};

        int [] res = minSlidingWindow(nums, 3);

        for ( int i : res ) {
            System.out.println(i);
        }

        nums = new int []{1,3,1,2,0,5};

        res = minSlidingWindow(nums, 3);

        for ( int i : res ) {
            System.out.println(i);
        }
    }

}
