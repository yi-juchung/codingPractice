import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsDuplicateIII {
    static public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k<1 || t<0 || nums==null || nums.length<2) return false;

        SortedSet<Long> curSet = new TreeSet<Long>();
        for (int i=0;i<nums.length;i++) {
            SortedSet<Long> foundSet = curSet.subSet((long)nums[i]-t,(long)nums[i]+t+1);

            if (!foundSet.isEmpty()) {
                return true;
            }

            if (i >= k) {
                curSet.remove((long)nums[i-k]);
            }

            curSet.add((long)nums[i]);
        }

        return false;
    }

    public static void main(String [ ] args) {

        int [] num = new int[] {3,1,1,3,7,7,3,3,4,3,6,3};
        System.out.print(containsNearbyAlmostDuplicate(num, 2, 4));
    }
}
