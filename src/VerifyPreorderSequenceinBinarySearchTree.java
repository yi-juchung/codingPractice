import java.util.Stack;

public class VerifyPreorderSequenceinBinarySearchTree {
//    static public boolean verifyPreorder(int[] preorder) {
//        int bound = Integer.MIN_VALUE;
//
//        Stack<Integer> st = new Stack<>();
//        for (int i : preorder) {
//            if (i < bound)
//                return false;
//
//            while (!st.isEmpty() && st.peek() < i) {
//                bound = st.pop();
//            }
//
//            st.push(i);
//        }
//
//        return true;
//    }

    static public boolean verifyPreorder(int[] preorder) {
        int bound = Integer.MIN_VALUE;
        int idx = -1;

        for (int i: preorder) {
            if (i < bound) {
                return false;
            }

            while (idx >= 0 && preorder[idx] < i) {
                bound = preorder[idx];
                idx -= 1;
            }

            idx++;
            preorder[idx] = i;
        }

        return true;
    }

    public static void main(String [ ] args) {
        int [] nums = new int [] {5,2,1,4,3,9,6,7,13};

        System.out.println(verifyPreorder(nums));

        nums = new int [] {1,2,3,4};

        System.out.println(verifyPreorder(nums));
    }
}
