public class MaximumSqrt {
    static public int [] maxSqrt(int input) {
        int maxS = searchSqrt(1,input/2, input);

        return new int[]{maxS,input/(maxS*maxS)};
    }

    static public int searchSqrt(int start, int end, int input) {
        if (end < start)
            return -1;
        else if (end == start) {
            double d = start*start;
            if (input%d == 0)
                return start;
            else
                return -1;
        }

        int mid = start + (end-start)/2;
        double midP = mid*mid;

        if (midP > input) {
            return searchSqrt(start, mid-1, input);
        } else {
            int left = searchSqrt(start, mid, input);
            int right = searchSqrt(mid+1, end, input);

            if (right > left)
                return right;
            else
                return left;
        }
    }

    public static void main(String [ ] args) {
        int [] out = maxSqrt(8);

        System.out.println(out[0]);
        System.out.println(out[1]);
    }
}
