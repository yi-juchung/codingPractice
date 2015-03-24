public class SingleNumberII {
    static public int singleNumber(int[] A) {
        int ans = 0;

        for (int b=0;b<32;b++) {
            int count = 0;
            int curBit = 1<<b;

            for (int i=0;i<A.length;i++) {
                if ((A[i] & curBit) != 0) {
                    count++;
                }
            }

            if (count%3 != 0) {
                ans |= curBit;
            }
        }

        return ans;
    }

    public static void main(String [ ] args) {
        int [] val = new int []{2,4,5,2,4,2,4};

        System.out.println(singleNumber(val));
    }
}
