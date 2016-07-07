public class UniqueBinarySearchTrees {
    static public int numTrees(int n) {
        if (n < 3) {
            return n;
        }

        int [] nums = new int [n+1];
        nums[0] = 1;
        nums[1] = 1;
        nums[2] = 2;

        for (int i = 3;i < n+1;i++) {
            int tot = 0;

            for (int j=i-1;j>=0;j--) {
                tot += nums[j]*nums[i-j-1];
            }

            nums[i] = tot;
        }

        return nums[n];
    }

    public static void main(String [ ] args) {
        System.out.println(numTrees(3));

        System.out.println(numTrees(5));
    }
}
