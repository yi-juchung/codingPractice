import java.util.HashMap;

public class MaxPointsonaLine {

    static class Point {
        int x;
        int y;

        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    static public int maxPoints(Point[] points) {

        HashMap<Double, Integer> slopes = new HashMap<Double, Integer>();

        int maxCount = 0;
        for (int i=0;i<points.length;i++) {
            int same = 0;
            int vertical = 0;

            for (int j=i+1;j<points.length;j++) {
                double slope = 0.0;

                if (points[i].y == points[j].y) {
                    if (points[i].x == points[j].x) {
                        same++; continue;
                    }

                    vertical++; continue;
                } else if (points[i].x == points[j].x) {
                    slope = Double.MAX_VALUE;
                } else {
                    slope = (1.0 * (points[i].y-points[j].y))/(points[i].x-points[j].x);
                }

                if (slopes.containsKey(slope)) {
                    slopes.put(slope,slopes.get(slope)+1);
                } else {
                    slopes.put(slope,2);
                }
            }

            for (int count : slopes.values()) {
                if (count+same > maxCount)
                    maxCount = count+same;
            }

            if (vertical+same+1 > maxCount)
                maxCount = vertical+same+1;

            slopes.clear();
        }

        return maxCount;
    }

    public static void main(String [ ] args) {

        Point [] points = new Point[3];
        points[0] = new Point(4,0);
        points[1] = new Point(4,-1);
        points[2] = new Point(4,5);
//        points[3] = new Point(7,4);
//        points[4] = new Point(14,8);
//        points[5] = new Point(2,9);
//        points[6] = new Point(9,9);

        System.out.println(maxPoints(points));
    }
}
