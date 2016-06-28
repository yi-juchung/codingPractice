public class MinRotatedArray {

    static int getMin(int [] num) {
        return helper(num,0,num.length-1);
    }

    static int helper(int [] num, int start, int end) {
        if (start == end) {
            return num[start];
        }

        int mid = start+(end-start)/2;
        if (num[start] > num[end]) {
            if (num[mid] > num[end]) {
                return helper(num, mid+1,end);
            } else {
                return helper(num, start+1,mid);
            }
        } else {
            if (num[mid] > num[end]) {
                return helper(num,mid+1,end);
            } else {
                return helper(num,start,mid-1);
            }
        }
    }

    public static void main(String [ ] args) {
        int [] num = {5,1,1,2,3,4,5};

        System.out.print(getMin(num));
    }
}
