public class ProductofArrayExceptSelf {
    static public int[] productExceptSelf(int[] nums) {
        int [] res = new int [nums.length];

        res[nums.length-1] = 1;
        for (int i=nums.length-2;i>=0;i--) {
            res[i] = nums[i+1]*res[i+1];
        }

        int left = nums[0];
        for (int i=1;i<nums.length;i++) {
            res[i] = left*res[i];
            left *= nums[i];
        }

        return res;
    }

    public static void main(String [ ] args) {
        int [] val = new int []{1,2,3,4};

        for ( int i : productExceptSelf(val) ) {
            System.out.println(i);
        }
    }
}
