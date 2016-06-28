public class PaintHouse {
    static public int minCost(int[][] costs) {
        int [] cur = new int [3];
        int [] prev = new int [3];
        prev[0] = costs[0][0];
        prev[1] = costs[0][1];
        prev[2] = costs[0][2];

        for (int i=1;i<costs.length;i++) {
            cur[0] = costs[i][0]+Math.min(prev[1],prev[2]);
            cur[1] = costs[i][1]+Math.min(prev[0],prev[2]);
            cur[2] = costs[i][2]+Math.min(prev[0],prev[1]);

            prev[0] = cur[0];
            prev[1] = cur[1];
            prev[2] = cur[2];
        }

        return Math.min(cur[0],Math.min(cur[1],cur[2]));
    }

    public static void main(String [ ] args) {
        int [][] costs = new int [][] {
                {5,8,6},
                {19,14,13},
                {7,5,12},
                {14,15,17},
                {3,20,10}
        };

        System.out.println(minCost(costs));
    }
}
