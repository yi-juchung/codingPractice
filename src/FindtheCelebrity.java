public class FindtheCelebrity {
    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

    static public boolean knows(int a, int b) {
        return true;
    }

    static public int findCelebrity(int n) {
        int res = -1;

        int i = 0; int j = n-1;

        while (i < j) {
            if (knows(i,j)) {
                i++;
                res = j;
            } else {
                j--;
                res = i;
            }
        }

        for (i=0;i<n;i++) {
            if (i == res)
                continue;

            if (!knows(i,res)) {
                return -1;
            }
        }

        return res;
    }

    public static void main(String [ ] args) {
        System.out.println(findCelebrity(3));
    }
}
