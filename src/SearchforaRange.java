public class SearchforaRange {
    static public int[] searchRange(int[] nums, int target) {
        int [] res = new int [] {-1,-1};

        res[0] = helper(nums,0,nums.length-1,true,target);
        if (res[0] != -1) {
            res[1] = helper(nums,res[0],nums.length-1,false,target);
        }

        return res;
    }

    static public int helper(int[] nums, int start, int end, boolean findLeft, int target) {
        if (start == end) {
            return (nums[start] == target)?start:-1;
        } else if (start > end) {
            return -1;
        }

        int mid = start + (end-start)/2;
        int cand = -1;

        if (nums[mid] == target) {
            if (findLeft) {
                cand = helper(nums,start,mid-1,findLeft, target);
            } else {
                cand = helper(nums,mid+1,end,findLeft, target);
            }

            if (cand == -1) {
                return mid;
            } else {
                return cand;
            }
        } else if (nums[mid] < target) {
            cand = helper(nums,mid+1, end,findLeft, target);
        } else {
            cand = helper(nums,start, mid-1,findLeft, target);
        }

        return cand;
    }

    public static void main(String [ ] args) {
        int [] num = {5, 7, 7, 8, 8, 10};

        // 3,4
        int [] res = searchRange(num, 8);
        System.out.print(res[0]+" "+res[1]);
    }
}
