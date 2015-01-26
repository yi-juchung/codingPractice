public class GasStation {
    static public int canCompleteCircuit(int[] gas, int[] cost) {
        int [] diff = new int [gas.length];

        int firstPos = -1;
        for (int i=0;i<gas.length;i++) {
            diff[i] = gas[i]-cost[i];
            if (i != 0) {
                diff[i] += diff[i-1];
            }

            if (diff[i] >= 0) {
                firstPos = i;
            }
        }

        if (firstPos != -1) {
            return firstPos;
        } else {
            int preDiff = diff[firstPos];
            for (int i=firstPos+gas.length-1;;i--) {
                if (diff[i%gas.length] < 0 && diff[i%gas.length] > preDiff) {
                    return (i+2)%gas.length;
                }
                preDiff = diff[i%gas.length];
            }
        }
    }

    public static void main(String [ ] args) {
        int [] gas = {1,2,3,4,5};
        int [] cost = {3,4,5,1,2};

        System.out.print(canCompleteCircuit(gas, cost));
    }
}
