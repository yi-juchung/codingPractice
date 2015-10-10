public class MaximumProduct {
    static public int maxProduct(int[] A, int num) {
        if (A.length < num)
            return 0;

        int curMax = 1;
        int max = 1;
        for (int i=0;i<num;i++) {
            curMax *= A[i];
        }

        if (curMax > max) {
            max = curMax;
        }

        for (int i=num;i<A.length;i++) {
            curMax *= A[i];
            curMax /= A[i-num];

            if (curMax > max) {
                max = curMax;
            }
        }

        return max;
    }

    public static void main(String [ ] args) {
        int [] num = {-2,2,3,8,-2,3,5,1,10,-5};

        System.out.print(maxProduct(num, 3));
    }
}
