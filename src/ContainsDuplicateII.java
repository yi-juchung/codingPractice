import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {

    static public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> check = new HashSet<Integer>();

        for (int i=0,j=0;j<nums.length;j++) {
            if (j-i > k) {
                check.remove(nums[i]);
                i++;
            }

            if (check.contains(nums[j])) {
                return true;
            } else {
                check.add(nums[j]);
            }
        }

        return false;
    }

    public static void main(String [ ] args) {
        int [] input = new int [] {-1,-1};
        System.out.println(containsNearbyDuplicate(input, 1));
    }
}
