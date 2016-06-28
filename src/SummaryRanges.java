import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
    static public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();

        return res;
    }

    public static void main(String [ ] args) {
        int [] nums = new int[] {
                0,1,2,4,5,7
        };

        List<String> res = summaryRanges(nums);

        for (String s : res) {
            System.out.println(s);
        }
    }
}
