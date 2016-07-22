public class BitwiseANDofNumbersRange {
    static public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        for(;i<32;i++)
            if(m>>i == n>>i)
                break;
        return (m>>i) << i;
    }

    public static void main(String [ ] args) {

        // 4
        System.out.println(rangeBitwiseAnd(5,7));
    }
}
