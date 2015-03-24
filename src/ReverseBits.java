public class ReverseBits {
    static public int reverseBits(int n) {
        int res =0;

        int count = 0;
        while (count < 32) {
            res <<= 1;
            res = res | 1 & (n >> count);
            count++;
        }

        return res;
    }
    public static void main(String [ ] args) {
        System.out.print(reverseBits(43261596));
    }
}
