import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GrayCode {
    static public List<Integer> grayCode(int n) {

        if (n == 0) {
            return new LinkedList<Integer>(){
                {
                    add(0);
                }
            };
        }

        int total = ((Double)Math.pow(2,n)).intValue();
        List<Integer> res = new ArrayList<Integer>(total);
        res.add(0);
        res.add(1);

        for(int digit=1;digit<n;digit++) {
            total = ((Double)Math.pow(2,digit+1)).intValue();
            List<Integer> newRes = new ArrayList<Integer>(total);
            newRes.addAll(res);

            for(int i=res.size()-1;i>=0;i--) {
                newRes.add(res.get(i) | 1<<digit);
            }

            res = newRes;
        }

        return res;
    }

    public static void main(String [ ] args) {
        for(int val : grayCode(3)) {
            System.out.println(val);
        }
    }
}
