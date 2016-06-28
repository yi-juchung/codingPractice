import java.util.LinkedList;
import java.util.List;

public class NestedListWeightSum {

    public static class NestedList {
        List<NestedList> lists;
        int num;
        boolean isInteger;

        public NestedList(int n) {
            num = n;
            isInteger = true;
        }

        public NestedList(List<NestedList> listList) {
            lists = listList;
            isInteger = false;
        }
    }

    public static int helper (NestedList nl, int dep) {
        int total = 0;

        if (nl.isInteger){
            total = nl.num*dep;
        } else {
            for (NestedList nld : nl.lists) {
                total += helper(nld,dep+1);
            }
        }

        return total;
    }

    public static void main(String [ ] args) {
        NestedList nl11 = new NestedList(1);
        NestedList nl12 = new NestedList(1);
        NestedList nl2 = new NestedList(2);
        NestedList nl31 = new NestedList(1);
        NestedList nl32 = new NestedList(1);

        List<NestedList> nl3 = new LinkedList<>();
        nl3.add(nl31);
        nl3.add(nl32);

        List<NestedList> nl1 = new LinkedList<>();
        nl1.add(nl11);
        nl1.add(nl12);

        List<NestedList> nl = new LinkedList<>();
        nl.add(new NestedList(nl1));
        nl.add(nl2);
        nl.add(new NestedList(nl3));

        System.out.print(helper(new NestedList(nl),0));
    }
}
