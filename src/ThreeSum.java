import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    static public List<List<Integer>> threeSum(int[] num) {

        Arrays.sort(num);

        List<List<Integer>> res = new LinkedList<List<Integer>>();

        for(int i=0;i<num.length-2;i++) {
            if(i>0 && num[i] == num[i-1])
                continue;
            int iVal = num[i];
            int left=i+1;
            int right=num.length-1;

            while(left<right) {
                int leftVal = num[left];
                int rightVal = num[right];
                int curTotal = iVal+leftVal+rightVal;

                if (curTotal == 0) {
                    List<Integer> newAns = new LinkedList<Integer>();
                    newAns.add(iVal);newAns.add(leftVal);newAns.add(rightVal);
                    res.add(newAns);
                    left++; right--;
                    while(left<right) {
                        if (num[left] != leftVal)
                            break;
                        left++;
                    }
                    while(left<right) {
                        if (num[right] != rightVal)
                            break;
                        right--;
                    }
                } else if (curTotal < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }

    public static void main(String [ ] args) {
        int [] val = new int []{-1,0,1,2,-1,-4};

        for(List internalList : threeSum(val)) {
            Iterator<Integer> iter = internalList.iterator();

            while(iter.hasNext()) {
                System.out.print(iter.next());
            }
            System.out.println();
        }
    }
}
