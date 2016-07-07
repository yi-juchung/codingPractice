public class BestTimetoBuyandSellStockwithCooldown {
    static public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int buym1 = 0, buy= -prices[0], sell=0, sellm1=0;

        for (int i : prices) {
            buym1 = buy;
            buy = Math.max(buym1, sellm1-i);
            sellm1 = sell;
            sell = Math.max(buym1+i, sellm1);
        }

        return sell;
    }

    public static void main(String [ ] args) {
        int [] nums = new int [] {1, 2, 3, 0, 2};

        System.out.println(maxProfit(nums));
    }
}
