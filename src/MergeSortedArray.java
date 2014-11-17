public class MergeSortedArray {
    static public void merge(int A[], int m, int B[], int n) {

        int i = m-1;
        int j = n-1;
        int done = m+n-1;

        while (done >= 0) {
            if (j < 0) {
                return;
            } else if (i < 0) {
                A[done] = B[j];
                j--;
            } else if (A[i] > B[j]) {
                A[done] = A[i];
                i--;
            } else {
                A[done] = B[j];
                j--;
            }
            done--;
        }


    }

    public static void main(String [ ] args) {
        int [] A = {1,3,7,0,0};
        int [] B = {2,4};

        merge(A,3,B,2);

        for(int i : A) {
            System.out.println(i);
        }
    }
}
