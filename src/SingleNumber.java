public class SingleNumber {
    static public int singleNumber(int[] A) {
        int result = 0;
        for (int i : A) result ^= i;
        return result;
    }

    public static void main(String [ ] args) {
        int [] val = new int []{2,4,2,4,5};

        System.out.println(singleNumber(val));
    }
}
