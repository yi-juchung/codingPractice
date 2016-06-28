import java.util.HashMap;

public class TwoSumIII {

    public static class TwoSum {
        HashMap<Integer,Integer> res;

        public TwoSum() {
            res = new HashMap<>();
        }

        public void add (int num) {
            if (res.containsKey(num)) {
                res.put(num,res.get(num)+1);
            } else {
                res.put(num,1);
            }
        }

        public boolean find (int num) {
            for (int i : res.keySet()) {
                int target = num-i;
                if (res.containsKey(target)) {
                    if (i == target && res.get(target) < 2)
                        continue;

                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String [ ] args) {

        TwoSum ts = new TwoSum();
        ts.add(1);
        ts.add(3);
        ts.add(5);

        System.out.println(ts.find(4));
        System.out.println(ts.find(7));
    }
}
