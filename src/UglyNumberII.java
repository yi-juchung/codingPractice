import java.util.ArrayList;
import java.util.List;

public class UglyNumberII {
    static public int nthUglyNumber(int n) {
        List<Integer> res = new ArrayList<>(n);
        res.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (res.size() <= n) {
            int m2 = res.get(i2)*2;
            int m3 = res.get(i3)*3;
            int m5 = res.get(i5)*5;

            int m = Math.min(m2,Math.min(m3,m5));
            if (m2 == m) {
                i2++;
            }

            if (m3 == m) {
                i3++;
            }

            if (m5 == m) {
                i5++;
            }
            res.add(m);
        }

        return res.get(n-1);
    }

    public static void main(String [ ] args) {

        // 12
        System.out.println(nthUglyNumber(10));
    }
}
