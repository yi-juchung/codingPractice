import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    static public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);

        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for(int j=0;j<num.length-3;j++) {
            if(j>0 && num[j] == num[j-1])
                continue;
            int find = target-num[j];
            for(int i=j+1;i<num.length-2;i++) {
                if(i>j+1 && num[i] == num[i-1])
                    continue;
                int iVal = num[i];
                int left=i+1;
                int right=num.length-1;

                while(left<right) {
                    int leftVal = num[left];
                    int rightVal = num[right];
                    int curTotal = iVal+leftVal+rightVal;

                    if (curTotal == find) {
                        List<Integer> newAns = new LinkedList<Integer>();
                        newAns.add(num[j]); newAns.add(iVal);newAns.add(leftVal);newAns.add(rightVal);
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
                    } else if (curTotal < find) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String [ ] args) {
        int [] num = {-1,0,1,2,-1,-4};

        List<List<Integer>> res = fourSum(num, -1);

        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
