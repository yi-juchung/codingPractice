import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSumII {

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

    public static int sum (NestedList nl) {
        List<Integer> listSum = new LinkedList<>();

        helper(listSum,0,nl);

//        Queue<NestedList> next = new LinkedList<>();
//        next.add(nl);
//        next.add(null);
//
//        int curSum = 0;
//        while (!next.isEmpty()) {
//            NestedList nestedList = next.poll();
//
//            if (nestedList == null) {
//                listSum.add(curSum);
//                curSum = 0;
//
//                if (!next.isEmpty()) {
//                    next.add(null);
//                }
//                continue;
//            }
//
//            if (nestedList.isInteger) {
//                curSum +=nestedList.num;
//            } else {
//                for (NestedList inner : nestedList.lists) {
//                    if (inner.isInteger) {
//                        curSum += inner.num;
//                    } else {
//                        next.addAll(inner.lists);
//                    }
//                }
//            }
//        }

        int res = 0;
        int n = listSum.size();
        for (int i=0;i<listSum.size();i++) {
            res += listSum.get(i)*(n-i);
        }

        return res;
    }

    public static void helper (List<Integer> sum, int dep, NestedList nl) {
        if (sum.size() == dep) {
            sum.add(0);
        }

        if (nl.isInteger) {
            sum.set(dep,sum.get(dep)+nl.num);
        } else {
            int num = 0;
            for (NestedList n : nl.lists) {
                if (n.isInteger) {
                    num += n.num;
                } else {
                    helper(sum,dep+1,n);
                }
            }
            sum.set(dep,sum.get(dep)+num);
        }
    }


    // another solution
    public static int sumv2 (NestedList nl) {

        Queue<NestedList> next = new LinkedList<>();
        next.add(nl);
        next.add(null);

        int curSum = 0;
        int total = 0;
        while (!next.isEmpty()) {
            NestedList cur = next.poll();

            if (cur == null) {
                if (!next.isEmpty()) {
                    next.add(new NestedList(curSum));
                    next.add(null);
                    total += curSum;
                    curSum = 0;
                }

                continue;
            }

            if (cur.isInteger) {
                curSum += cur.num;
            } else {
                for (NestedList inner : cur.lists) {
                    if (inner.isInteger) {
                        curSum += inner.num;
                    } else {
                        next.addAll(inner.lists);
                    }
                }
            }
        }

        return total+curSum;
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

        System.out.print(sumv2(new NestedList(nl)));
    }
}
