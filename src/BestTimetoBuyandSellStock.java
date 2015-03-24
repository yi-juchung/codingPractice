public class BestTimetoBuyandSellStock {
    static public int maxProfit(int[] prices) {
        int res = 0;

        int curMin = Integer.MAX_VALUE;

        for (int i=0;i<prices.length;i++) {
            if (prices[i] < curMin) {
                curMin = prices[i];
            } else if (prices[i]-curMin > res) {
                res = prices[i]-curMin;
            }
        }

        return res;
    }

    public static void main(String [ ] args) {
        int [] val = new int []{1,2,3,4,5,6,3,5,1};

        System.out.println(maxProfit(val));
    }
}
