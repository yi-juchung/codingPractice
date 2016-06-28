import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays {

    static public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> inter = new HashSet<>();

        for (int i : nums1) {
            if (!inter.contains(i)) {
                inter.add(i);
            }
        }

        Set<Integer> res = new HashSet<>();

        for (int i : nums2) {
            if (inter.contains(i)) {
                res.add(i);
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
        int [] nums1 = new int []{2,1};
        int [] nums2 = new int []{1,2};

        for(int i : intersection(nums1,nums2)) {
            System.out.println(i);
        }

    }
}
