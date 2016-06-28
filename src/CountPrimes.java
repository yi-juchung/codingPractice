public class CountPrimes {
    static public int countPrimes(int n) {
        boolean [] isPrime = new boolean[n];

        for (int i=2;i<n;i++) {
            isPrime[i] = true;
        }

        for (int i=2;i*i<n;i++) {
            if (!isPrime[i]) continue;

            for (int j = i*i;j<n;j += i) {
                isPrime[j] = false;
            }
        }

        int res = 0;
        for (int i=2;i<n;i++) {
            if (isPrime[i]) res++;
        }

        return res;
    }

    public static void main(String [ ] args) {
        System.out.println(countPrimes(3));
    }
}
