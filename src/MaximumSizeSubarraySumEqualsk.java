import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsk {
//    static public int getMax(int [] input, int k) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        map.put(0,-1);
//
//        int maxLen = 0;
//        int sum = 0;
//        for (int i=0;i<input.length;i++) {
//            int in = input[i];
//            sum += in;
//            if (!map.containsKey(in)) {
//                map.put(in,i);
//            }
//
//            if (map.containsKey(sum-k)) {
//                int prev = map.get(sum-k);
//                if (i-prev > maxLen) {
//                    maxLen = i-prev;
//                }
//            }
//        }
//
//        return maxLen;
//    }

    static public int getMax(int [] input, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        int sum = 0;
        int max = 0;
        for (int i=0;i<input.length;i++) {
            sum += input[i];

            if (!map.containsKey(sum)) {
                map.put(sum,i);
            }

            if (map.containsKey(sum-k)) {
                if (i-map.get(sum-k) > max) {
                    max = i-map.get(sum-k);
                }
            }
        }

        return max;
    }

    public static void main(String [ ] args) {
        int [] nums = new int []{1, -1, 5, -2, 3};

        System.out.println(getMax(nums,3));


        nums = new int []{-2, -1, 2, 1};

        System.out.println(getMax(nums,1));
    }
}
