public class MaximumProductSubarray {
    static public int maxProduct(int[] A) {
        int curMax = Integer.MIN_VALUE;
        int [] calArray = A.clone();

        for (int i=0;i<A.length;i++) {
            if (calArray[i] > curMax) {
                curMax = calArray[i];
            }
        }

        for (int i=1;i<A.length;i++) {
            int bording = A.length-i-1;
            for (int j=0;j<bording;j++) {
                calArray[j] *= A[j+i];

                if (calArray[j] > curMax) {
                    curMax = calArray[j];
                }
            }
        }

        return curMax;
    }

    static public int maxProductv2(int[] A) {
        int maxSoFar = 1;
        int minSoFar = 1;

        int curMax = Integer.MIN_VALUE;
        boolean maxDefault = true;

        for (int i=0;i<A.length;i++) {
            if (A[i] > 0) {
                maxSoFar *= A[i];
                minSoFar = Math.min(minSoFar*A[i],1);
                maxDefault = false;
            } else if (A[i] == 0) {
                maxSoFar = 1;
                minSoFar = 1;
                maxDefault = true;
            } else {
                int temp = maxSoFar;
                int newMax = minSoFar*A[i];
                if (newMax >= 1)
                    maxDefault = false;
                else
                    maxDefault = true;
                maxSoFar = Math.max(minSoFar*A[i],1);
                minSoFar = temp*A[i];
            }

            if (!maxDefault && maxSoFar > curMax) {
                curMax = maxSoFar;
            } else if (A[i] > curMax) {
                curMax = A[i];
            }
        }

        return curMax;
    }

    public static void main(String [ ] args) {
        int [] num = {-2};

        System.out.print(maxProductv2(num));
    }
}
