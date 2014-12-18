public class FindPeakElement {
    static public int findPeakElement(int[] num) {

         return helper(num, 0, num.length-1);
    }

    static public int helper(int[] num, int begin, int end) {
        int midIdx = begin+(end-begin)/2;

        if ((midIdx == 0 || num[midIdx-1] < num[midIdx]) &&
             (midIdx == num.length-1 || num[midIdx+1] < num[midIdx])) {
            return midIdx;
        } else if (midIdx > 0 && num[midIdx-1] > num[midIdx]) {
            return helper(num, begin, midIdx-1);
        } else {
            return helper(num, midIdx+1, end);
        }
    }

    public static void main(String [ ] args) {
        int [] num = {1, 2, 3, 1};

        System.out.print(findPeakElement(num));
    }
}
