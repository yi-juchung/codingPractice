public class MovingAveragefromDataStream {

    public static class MovingAverage {
        int [] nums;
        int curSum;
        int count;

        public MovingAverage(int n) {
            curSum = 0;
            count = 0;
            nums = new int [n];
        }

        public int next (int n) {
            count++;
            curSum -= nums[count%nums.length];
            curSum += n;
            nums[count%nums.length] = n;

            if (count > nums.length) {
                return curSum/nums.length;
            } else {
                return curSum/count;
            }
        }
    }

    public static void main(String [ ] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }
}
