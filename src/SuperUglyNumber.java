import java.util.Arrays;

public class SuperUglyNumber {
    static public int nthSuperUglyNumber(int n, int[] primes) {
        int [] pos = new int [primes.length];
        int [] ugly = new int [n];
        Arrays.fill(ugly, Integer.MAX_VALUE);

        ugly[0] = 1;

        for (int i=1;i<n;i++) {
            for (int j=0;j<primes.length;j++) {
                ugly[i] = (ugly[i] < ugly[pos[j]] * primes[j]) ? ugly[i] : (ugly[pos[j]] * primes[j]);
            }

            for (int j=0;j<primes.length;j++) {
                if (ugly[i] == ugly[pos[j]] * primes[j]) {
                    pos[j]++;
                }
            }
        }

        return ugly[n-1];
    }

    public static void main(String [ ] args) {
        int [] primes = new int[]{2, 7, 13, 19};


        // [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]
        // 13
        System.out.println(nthSuperUglyNumber(6,primes));
    }
}
