public class FindMinimumRotatedSortedArray {
    static public int findMin(int[] num) {
        return helperv2(num, 0, num.length-1);
    }

    static public int helper(int [] num, int begin, int end) {
        if (begin > end) {
            return Integer.MAX_VALUE;
        }
        int midIdx = begin+(end-begin)/2;
        int right = (midIdx < end)?num[midIdx+1]:num[0];
        int left = (midIdx > 0)?num[midIdx-1]:num[num.length-1];

        if (num[midIdx] >= right) {
            return right;
        } else {
            if (num[midIdx] <= left) {
                return num[midIdx];
            } else {
                return Math.min(helper(num, begin, midIdx-1), helper(num, midIdx+1, end));
            }
        }
    }

    static public int helperv2(int [] num, int begin, int end) {
        if (begin == end)
            return num[begin];

        int midIdx = begin+(end-begin)/2;

        if (num[midIdx] < num[end]) {
            return helperv2(num, begin, midIdx);
        } else {
            return helperv2(num, midIdx+1, end);
        }
    }

    public static void main(String [ ] args) {
        int [] num = {2,1};

        System.out.print(findMin(num));
    }
}
