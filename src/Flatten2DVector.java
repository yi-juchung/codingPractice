public class Flatten2DVector {
    static public class Vector2D {
        int [] nums;
        int iter;

        public Vector2D (int [][] m) {
            iter = 0;
            if (m == null) {
                nums = new int [0];
            } else {
                int count = 0;
                for (int i=0;i<m.length;i++) {
                    count += m[i].length;
                }
                nums = new int [count];
                count = 0;
                for (int i=0;i<m.length;i++) {
                    for (int j=0;j<m[i].length;j++) {
                        nums[count++] = m[i][j];
                    }
                }
            }
        }

        public int next() {
            if (hasNext()) {
                return nums[iter++];
            } else {
                return Integer.MIN_VALUE;
            }
        }

        public boolean hasNext() {
            return iter < nums.length;
        }
    }

    public static void main(String [ ] args) {
        int [][] m = new int [][] {
            {1,2},
            {3},
            {4,5,6}
        };

        Vector2D v = new Vector2D(m);

        while (v.hasNext()) {
            System.out.println(v.next());
        }
    }
}
