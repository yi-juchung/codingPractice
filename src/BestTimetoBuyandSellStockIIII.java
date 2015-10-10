public class BestTimetoBuyandSellStockIIII {
    static public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1) {
            return 0;
        } else if (k >= prices.length) {
            return unlimitTransactions(prices);
        }

        int [][] global = new int[2][k+1];
        int [][] local = new int[2][k+1];

        for (int i=1;i<prices.length;i++) {
            int diff = prices[i] - prices[i-1];
            int curIdx = i%2;
            int prvIdx = (i-1)%2;
            for (int j=1;j<k+1;j++) {
                local[curIdx][j] = Math.max(global[prvIdx][j-1]+Math.max(0,diff),local[prvIdx][j]+diff);
                global[curIdx][j] = Math.max(local[curIdx][j], global[prvIdx][j]);
            }
        }

        return global[(prices.length-1)%2][k];
    }

    static public int unlimitTransactions(int[] prices) {
        int res = 0;

        for (int i=1;i<prices.length;i++) {
            if (prices[i] > prices[i-1]) {
                res += prices[i]-prices[i-1];
            }
        }

        return res;
    }

    public static void main(String [ ] args) {
        int [] val = new int []{1,10,4,5,2,11};

        System.out.println(maxProfit(2, val));
    }
}
