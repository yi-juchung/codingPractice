public class SuperPow {
    static public int superPow(int a, int[] b) {
        int res = 1;

        a %= 1337;
        for (int i=0;i < b.length;i++) {
            res = pow(res, 10)*(pow(a,b[i])%1337);
            res %= 1337;
        }

        return res;
    }

    static public int pow (int a, int b) {
        if (a == 1 || b == 1) {
            return a;
        } else if (b == 0) {
            return 1;
        }

        int x = pow(a,b/2);
        x *= x;
        x %= 1337;

        if (b%2 == 1) {
            x *= a;
            x %= 1337;
        }

        return x;
    }

    public static void main(String [ ] args) {
        int [] b = new int []{3};

        // 8
        System.out.println(superPow(2,b));

        b = new int []{1,0};

        // 1024
        System.out.println(superPow(2,b));
    }
}
