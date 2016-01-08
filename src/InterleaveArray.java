public class InterleaveArray {

    static void interval(int [] num) {
        helper(num,0,num.length-1);
    }

    static void helper(int [] num, int i, int j) {
        if (j-i < 2)
            return;

        if (j-i < 4) {
            int temp = num[i+1];
            num[i+1] = num[i+2];
            num[i+2] = temp;
            return;
        }

        int k = (j-i+1)/2;
        int fSize = k/2;
        int sSize = k-fSize;
        int m = i+fSize+sSize;

        swap(num,i+fSize,j-sSize,m);

        helper(num,i,m-1);
        helper(num,m,j);
    }

    static void swap(int [] num, int s, int e, int m) {
        rev(num,s,e);
        rev(num,s,m-1);
        rev(num,m,e);
    }

    static void rev(int [] num, int s, int e) {
        while (s<e) {
            int temp = num[s];
            num[s] = num[e];
            num[e] = temp;
            s++; e--;
        }
    }

    public static void main(String [ ] args) {

        int [] num = new int[]{1,2,3};
        interval(num);

        for (int i : num) {
            System.out.print(i);
        }
    }
}
