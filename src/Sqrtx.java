public class Sqrtx {
    static public int mySqrt(int x) {
        if (x <= 1) return x;

        int start = 1;
        int end = x;

        while (start < end) {
            int mid = start + (end-start)/2;
            if (mid <= x/mid) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        return start-1;
    }

    public static void main(String [ ] args) {
        // 3
        System.out.println(mySqrt(16));
    }
}
