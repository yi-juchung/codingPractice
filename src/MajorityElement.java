public class MajorityElement {

    static public int majorityElement(int[] num) {
        int cand = num[0];
        int count = 1;

        for (int i=1;i<num.length;i++) {
            if (cand != num[i]) {
                count--;
                if (count == 0) {
                    cand = num[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }

        return cand;
    }

    public static void main(String [ ] args) {

        int [] num = new int[] {3,1,1,3,7,7,3,3,4,3,6,3};
        System.out.print(majorityElement(num));
    }
}
