public class SortTransformedArray {
    static public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int [] res = new int [nums.length];

        int i = 0;
        int j = nums.length-1;

        int resIdx = (a>=0)?nums.length-1:0;

        while (i<=j) {
            int api = apply(nums[i],a,b,c);
            int apj = apply(nums[j],a,b,c);

            if (a >= 0) {
                if (api > apj) {
                    res[resIdx--] = api;
                    i++;
                } else {
                    res[resIdx--] = apj;
                    j--;
                }
            } else {
                if (api > apj) {
                    res[resIdx++] = apj;
                    j--;
                } else {
                    res[resIdx++] = api;
                    i++;
                }
            }
        }

        return res;
    }

    static public int apply (int x, int a, int b, int c) {
        return a*x*x+b*x+c;
    }

    public static void main(String [ ] args) {

        int [] nums = new int [] {-4, -2, 2, 4};

        for (int i: sortTransformedArray(nums,1,3,5)) {
            System.out.println(i);
        }

        System.out.println();
        nums = new int [] {-4, -2, 2, 4};

        for (int i: sortTransformedArray(nums,-1,3,5)) {
            System.out.println(i);
        }
    }
}
