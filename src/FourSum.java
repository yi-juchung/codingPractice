import java.util.List;

public class FourSum {
    static public List<List<Integer>> fourSum(int[] num, int target) {

    }

    public static void main(String [ ] args) {
        int [] num = {1,0,-1,0,-2,2};

        List<List<Integer>> res = fourSum(num, 0);

        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
