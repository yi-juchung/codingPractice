public class RectangleArea {
    static public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int total = (G-E)*(H-F) + (C-A)*(D-B);
        if (C < E || G < A || D < F || B > H) {
            return total;
        }

        int left = Math.max(A,E);
        int right = Math.min(C,G);
        int top = Math.min(H,D);
        int bot = Math.max(F,B);

        return total - (right-left)*(top-bot);
    }

    public static void main(String [ ] args) {
        // 16
        System.out.println(computeArea(-2, -2, 2, 2, -2, -2, 2, 2));

        // 4
        System.out.println(computeArea(0,0,0,0,-1,-1,1,1));
    }
}
