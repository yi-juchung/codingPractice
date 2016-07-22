import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LargestDivisibleSubset {
    static public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int [] fromIdx = new int [nums.length];
        int [] maxLen = new int [nums.length];

        Arrays.fill(maxLen, 1);
        Arrays.sort(nums);
        int curMaxLen = 1;
        int curMaxIdx = 0;
        for (int i=0;i<nums.length;i++) {
            for (int j=0;j<i;j++) {
                if (nums[i] % nums[j] == 0) {
                    if (maxLen[j]+1 > maxLen[i]) {
                        maxLen[i] = maxLen[j]+1;
                        fromIdx[i] = j;
                    }
                }
            }

            if (maxLen[i] > curMaxLen) {
                curMaxLen = maxLen[i];
                curMaxIdx = i;
            }
        }

        return res(fromIdx,nums,curMaxIdx,curMaxLen);
    }

    static public List<Integer> res(int [] fromIdx, int [] nums, int idx, int maxLen) {
        List<Integer> res = new LinkedList<>();
        while (maxLen-- != 0) {
            res.add(nums[idx]);
            idx = fromIdx[idx];
        }

        return res;
    }

    public static void main(String [ ] args) {
        int [] nums = new int [] {1,2,3};

        // Result: [1,2] (of course, [1,3] will also be ok)
        for (int i : largestDivisibleSubset(nums)) {
            System.out.println(i);
        }

        nums = new int [] {1,2,4,8};

        // Result: [1,2,4,8]
        for (int i : largestDivisibleSubset(nums)) {
            System.out.println(i);
        }
    }
}
