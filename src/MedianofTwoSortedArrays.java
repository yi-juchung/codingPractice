public class MedianofTwoSortedArrays {
    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length+nums2.length)%2 == 0) {
            return (double)(helper(nums1,nums2,0,nums1.length,0,nums2.length,(nums1.length+nums2.length)/2)+helper(nums1,nums2,0,nums1.length-1,0,nums2.length-1,(nums1.length+nums2.length)/2+1))/2;
        } else {
            return helper(nums1,nums2,0,nums1.length,0,nums2.length,(nums1.length+nums2.length+1)/2);
        }
    }

    static public int helper(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int num) {
        int len1 = end1-start1;
        int len2 = end2-start2;

        if (len1 <= 0) {
            return nums2[start2+num-1];
        }

        if (len2 <= 0) {
            return nums1[start1+num-1];
        }

        if (num <= 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int mid1 = (start1+end1)/2;
        int mid2 = (start2+end2)/2;

        if (nums1[mid1] <= nums2[mid2]) {
            if (len1/2+len2/2+1 >= num)
                return helper(nums1,nums2,start1,end1,start2,mid2,num);
            else
                return helper(nums1,nums2,mid1+1,end1,start2,end2,num-len1/2-1);
        } else {
            if (len1/2+len2/2+1 >= num)
                return helper(nums1,nums2,start1,mid1,start2,end2,num);
            else
                return helper(nums1,nums2,start1,end1,mid2+1,end2,num-len2/2-1);
        }
    }

    public static void main(String [ ] args) {
        int [] nums1 = new int[]{1};
        int [] nums2 = new int[]{1};

        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
