import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {
    static public String getPermutation(int n, int k) {
        int [] fac = new int [n];
        List<Integer> num = new LinkedList<Integer>();
        fac[0]=1;
        for (int i=1;i<n;i++) {
            fac[i] = fac[i-1]*i;
        }

        for (int i=0;i<n;i++) {
            num.add(i+1);
        }

        k--;

        StringBuilder sb = new StringBuilder();
        for (int i=n;i>=1;i--) {
            int idx = k/fac[i-1];
            k %= fac[i-1];

            sb.append(num.get(idx));
            num.remove(idx);
        }

        return sb.toString();
    }

    public static void main(String [ ] args) {
        System.out.println(getPermutation(4, 9));
    }
}
