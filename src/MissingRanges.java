import java.util.LinkedList;
import java.util.List;

public class MissingRanges {
    static public List<String> findMissingRanges(int[] vals, int start, int end) {
        List<String> res = new LinkedList<>();

        int prev = -1;

        for (int i=0;i<vals.length;i++) {
            if (vals[i] != prev+1) {
                res.add(range(prev+1,vals[i]-1));
                prev = vals[i];
            } else {
                prev = vals[i];
            }
        }

        if (prev == -1) {
            res.add(range(0,99));
        } else if (prev != 99) {
            res.add(range(prev+1,99));
        }

        return res;
    }

    static public String range (int i, int j) {
        StringBuilder sb = new StringBuilder();
        if (i == j) {
            sb.append(i);
        } else {
            sb.append(i+"->"+j);
        }
        return sb.toString();
    }

    public static void main(String [ ] args) {
        int [] nums = new int[]{0, 1, 3, 50, 75};

        // “2”, “4->49”, “51->74”, “76->99”
        System.out.println(findMissingRanges(nums, 0, nums.length-1));

        nums = new int[]{0};

        // “2”, “4->49”, “51->74”, “76->99”
        System.out.println(findMissingRanges(nums, 0, nums.length-1));

        nums = new int[]{99};

        // “2”, “4->49”, “51->74”, “76->99”
        System.out.println(findMissingRanges(nums, 0, nums.length-1));
    }
}
