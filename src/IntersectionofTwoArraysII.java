import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class IntersectionofTwoArraysII {

    static public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> nums = new HashMap<>();

        int [] out = (nums1.length < nums2.length)?nums2:nums1;
        int [] inner = (nums1.length < nums2.length)?nums1:nums2;

        for (int i : out) {
            if (nums.containsKey(i)) {
                nums.put(i,nums.get(i)+1);
            } else {
                nums.put(i,1);
            }
        }
        List<Integer> res = new LinkedList<>();
        for (int i : inner) {
            if (nums.containsKey(i) && nums.get(i) > 0) {
                res.add(i);
                nums.put(i,nums.get(i)-1);
            }
        }

        int [] ret = new int [res.size()];
        int j = 0;
        for (int i : res) {
            ret[j++] = i;
        }

        return ret;
    }

    public static void main(String [ ] args) {
        int [] nums1 = new int []{1, 2, 2, 1};
        int [] nums2 = new int []{2,2};

        for(int i : intersection(nums1,nums2)) {
            System.out.println(i);
        }

    }
}
