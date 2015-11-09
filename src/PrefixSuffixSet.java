import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrefixSuffixSet {
    public static int findSet(int [] input) {
        HashMap<List<Integer>, Integer> calc = new HashMap<List<Integer>, Integer>();

        Set<Integer> bucket = new HashSet<Integer>();
        for (int i=0;i<input.length;i++) {
            bucket.add(input[i]);
            List<Integer> temp = new ArrayList<Integer>(bucket);

            if (calc.containsKey(temp)) {
                calc.put(temp,calc.get(temp)+1);
            } else {
                calc.put(temp,1);
            }
        }

        int pairs = 0;
        bucket.clear();
        for (int i=input.length-1;i>=0;i--) {
            bucket.add(input[i]);
            List<Integer> temp = new ArrayList<Integer>(bucket);

            if (calc.containsKey(temp)) {
                pairs += calc.get(temp);
            }
        }

        return pairs;
    }

    public static void main(String [ ] args) {
        int [] input = new int[]{1,2,3,1,2};

        System.out.print(findSet(input));
    }
}
