public class BestTimetoBuyandSellStockIII {
    static public int maxProfit(int[] prices) {
        int [] bestFirst = new int [prices.length];
        int [] bestSecond = new int [prices.length];

        int min = Integer.MAX_VALUE;
        int curMax = 0;

        for (int i = 0;i<prices.length;i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > curMax) {
                curMax = prices[i] - min;
            }

            bestFirst[i] = curMax;
        }

        curMax = 0;
        int max = Integer.MIN_VALUE;

        for (int i = prices.length-1;i >= 0;i--) {
            if (prices[i] > max) {
                max = prices[i];
            } else if (max - prices[i] > curMax) {
                curMax = max - prices[i];
            }

            bestSecond[i] = curMax;
        }

        int res = 0;

        for (int i=0;i<prices.length;i++) {
            if (bestFirst[i]+bestSecond[i] > res) {
                res = bestFirst[i]+bestSecond[i];
            }
        }

        return res;
    }

    public static void main(String [ ] args) {
        int [] val = new int []{1,10,4,5,2,11};

        System.out.println(maxProfit(val));
    }
}
