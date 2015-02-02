import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    static public String largestNumber(int[] num) {
        String[] nums = new String[num.length];
        for(int i =0 ;i<num.length;i++){
            nums[i]=String.valueOf(num[i]);
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s12 = o1 + o2;
                String s21 = o2 + o1;
                return -s12.compareTo(s21);
            }
        };
        Arrays.sort(nums, comparator);

        StringBuilder sb = new StringBuilder();

        for (String s : nums) {
            sb.append(s);
        }

        return sb.charAt(0) == '0'?"0":sb.toString();
    }

    public static void main(String [ ] args) {
        System.out.print(largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
