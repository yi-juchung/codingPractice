import java.util.HashMap;
import java.util.Map;

public class FractionRecurringDecimal {
    static public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0)
            return "0";

        StringBuilder sb = new StringBuilder();

        if (numerator < 0 ^ denominator < 0) {
            sb.append('-');
        }

        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);

        sb.append(n/d);

        if (n % d == 0)
            return sb.toString();

        sb.append('.');

        Map<Long, Integer> resMap = new HashMap<Long, Integer>();
        for (long r = n%d ; r != 0 ; r %= d) {
            if (resMap.containsKey(r)) {
                sb.insert((int)resMap.get(r),'(');
                sb.append(')');
                break;
            }

            resMap.put(r,sb.length());
            r *= 10;
            sb.append(r/d);
        }

        return sb.toString();
    }

    public static void main(String [ ] args) {
        System.out.print(fractionToDecimal(-1,-2147483648));
    }
}
