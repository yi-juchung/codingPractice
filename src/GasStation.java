public class GasStation {
    static public int canCompleteCircuit(int[] gas, int[] cost) {
        int [] diff = new int [gas.length];

        int total = 0;
        int curGas = 0;
        int starPoint = 0;
        for (int i=0;i<gas.length;i++) {
            diff[i] = gas[i]-cost[i];
            total += diff[i];
            curGas += diff[i];

            if (curGas < 0) {
                curGas = 0;
                starPoint = i+1;
            }
        }

        if (total < 0) {
            return -1;
        } else {
            return starPoint;
        }
    }

    public static void main(String [ ] args) {
        int [] gas = {1,2};
        int [] cost = {2,1};

        System.out.print(canCompleteCircuit(gas, cost));
    }
}
