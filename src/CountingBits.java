public class CountingBits {
    public static int[] countBits(int num) {
        int [] res = new int[num+1];

        if (num == 0) {
            return res;
        }

        int i=1;
        int step=1;
        while (i < res.length) {

            for (int j=0;j<step;j++) {
                res[i++] = res[j]+1;
                if (i == res.length)
                    break;
            }

            step += step;
        }

        return res;
    }

    public static void main(String [ ] args) {

        int [] res = countBits(16);

        for (int i : res) {
            System.out.println(i);
        }
    }
}
