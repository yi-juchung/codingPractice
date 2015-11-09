import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    static public boolean containsDuplicate(int[] nums) {
        Set<Integer> check = new HashSet<Integer>(nums.length);

        for (int i : nums) {
            if (check.contains(i)) {
                return true;
            } else {
                check.add(i);
            }
        }

        return false;
    }

    public static void main(String [ ] args) {
        int [] input = new int [] {0, 1, 0, 3, 12};


        System.out.println( containsDuplicate(input));
    }
}
