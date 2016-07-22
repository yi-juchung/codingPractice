import java.util.Arrays;

public class HIndex {
//    static public int hIndex(int[] citations) {
//        Arrays.sort(citations);
//        int i=0, j=citations.length-1;
//        while (i<j) {
//            int temp = citations[i];
//            citations[i] = citations[j];
//            citations[j] = temp;
//            i++; j--;
//        }
//
//        int maxH = 0;
//        for (i=0;i<citations.length;i++) {
//            if (citations[i] >= i+1) {
//                maxH = i+1;
//            }
//        }
//
//        return maxH;
//    }

    static public int hIndex(int[] citations) {
        int [] check = new int [citations.length+1];

        for (int i: citations) {
            if (i > citations.length) {
                check[citations.length]++;
            } else {
                check[i]++;
            }
        }

        int count = 0;

        for (int i=check.length-1;i>=0;i--) {
            count += check[i];
            if (count >= i) return i;
        }

        return 0;
    }

    public static void main(String [ ] args) {
        int [] cit = new int [] {3, 0, 6, 1, 5};

        System.out.println(hIndex(cit));
    }
}
