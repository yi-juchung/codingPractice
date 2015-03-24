public class BestTimetoBuyandSellStock2 {
    static public int maxProfit(int[] prices) {
        int res = 0;

        for (int i=1;i<prices.length;i++) {
            if (prices[i] > prices[i-1]) {
                res += prices[i]-prices[i-1];
            }
        }

        return res;
    }

    public static void main(String [ ] args) {
        int [] val = new int []{1,2,3,4,5,6,3,5,1};

        System.out.println(maxProfit(val));
    }
}
