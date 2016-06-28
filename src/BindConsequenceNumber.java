import java.util.LinkedList;
import java.util.List;

public class BindConsequenceNumber {

    static List<String> bind(int [] input) {
        List<String> res = new LinkedList<String>();

        int prvIdx = 0;
        int begIdx = 0;
        for (int i=1;i<input.length;i++) {
            if (input[prvIdx]+1 != input[i]) {
                if (prvIdx == begIdx) {
                    res.add(String.valueOf(input[begIdx]));
                } else {
                    res.add(input[begIdx]+"-"+input[prvIdx]);
                }

                begIdx = i;
            }

            prvIdx = i;
        }

        if (prvIdx == begIdx) {
            res.add(String.valueOf(input[begIdx]));
        } else {
            res.add(input[begIdx]+"-"+input[prvIdx]);
        }

        return res;
    }

    public static void main(String [ ] args) {
        int [] nums = new int[] {1,3,4,5,7};

        for (String s : bind(nums)) {
            System.out.println(s);
        }
    }
}
