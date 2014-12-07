public class RemoveElement {
    static public int removeElement(int[] A, int elem) {
        int curInt = 0;
        int newLen = 0;

        while(curInt < A.length) {

            if (A[curInt] != elem) {
                A[newLen++] = A[curInt];
            }

            curInt++;
        }

        return newLen;
    }

    public static void main(String [ ] args) {
        System.out.print(removeElement(new int []{2,3,9,5,10,2,3,4},5));
    }
}
