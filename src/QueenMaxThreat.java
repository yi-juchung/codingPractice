import java.util.HashMap;

public class QueenMaxThreat {

    public static int maxThreat(int [] input) {
        int [] threats = new int [input.length];

        HashMap<Integer,Integer> trackXmY = new HashMap<Integer, Integer>();
        HashMap<Integer,Integer> trackXpY = new HashMap<Integer, Integer>();

        for (int col=0;col < input.length;col++) {
            int xmy = input[col]-col;
            if (trackXmY.containsKey(xmy)) {
                threats[trackXmY.get(xmy)]++;
                threats[col]++;
            }

            trackXmY.put(xmy, col);

            int xpy = input[col]+col;
            if (trackXpY.containsKey(xpy)) {
                threats[trackXpY.get(xpy)]++;
                threats[col]++;
            }

            trackXpY.put(xpy, col);
        }

        int max = 0;

        for (int i : threats) {
            if (i > max)
                max = i;
        }

        return max;
    }

//    public static int maxThreat(int [] input) {
//        int [] threats = new int [input.length];
//
//        for (int col=0;col < input.length;col++) {
//            if (findThreat(input,threats, input[col], col, 1))
//                threats[col]++;
//            if (findThreat(input,threats, input[col], col, -1))
//                threats[col]++;
//        }
//
//        int max = 0;
//
//        for (int i : threats) {
//            if (i > max)
//                max = i;
//        }
//
//        return max;
//    }
//
//    public static boolean findThreat(int [] input, int [] threats, int row, int col, int direction) {
//
//        for (int i=col-1;i>=0;i--) {
//            row += direction;
//
//            if (row < 0 || row >= input.length) {
//                return false;
//            }
//
//            if (input[i] == row) {
//                threats[i]++;
//                return true;
//            }
//        }
//
//        return false;
//    }

    public static void main(String [ ] args) {
        int [] input = new int []{1,2,3};

        System.out.print(maxThreat(input));
    }
}
