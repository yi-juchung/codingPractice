public class PaintFence {

    public static int paintFence(int n, int k) {
        if (n < 2 || k == 0) {
            return n * k;
        }

        int same = k;
        int diff1 = k;
        int diff2 = k*(k-1);
        for (int i = 2;i<n;i++) {
            same = diff2;
            diff2 = (k-1)*(diff1+diff2);
            diff1 = same;
        }

        return same+diff2;
    }

    public static void main(String [ ] args) {

        System.out.println(paintFence(7,2));
    }
}
