public class HIndexII {

    static public int hIndex(int[] citations) {
        int res = 0;
        for (int i=0;i<citations.length;i++) {
            if (citations[i] >= citations.length-i) {
                return citations.length-i;
            }
        }

        return res;
    }

    public static void main(String [ ] args) {
        int [] cit = new int [] {0,1,3,6,5};

        System.out.println(hIndex(cit));
    }
}
