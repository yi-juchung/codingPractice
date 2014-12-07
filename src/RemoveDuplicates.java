public class RemoveDuplicates {
    static public int removeDuplicates(int[] A) {
        if (A.length == 0)
            return 0;

        int prevInt = A[0];
        int curIdx = 1;
        int newLen = 1;

        while (curIdx < A.length) {
            if (prevInt != A[curIdx]) {
                A[newLen++] = A[curIdx];
                prevInt = A[curIdx];
            }

            curIdx++;
        }

        return newLen;
    }

    public static void main(String [ ] args) {
        System.out.print(removeDuplicates(new int []{1,1,2}));
    }
}
