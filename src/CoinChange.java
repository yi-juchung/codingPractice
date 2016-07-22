public class CoinChange {
    static public int coinChange(int[] coins, int amount) {
        int [] mem = new int [amount+1];

        int min = Integer.MAX_VALUE;

        for (int i=1;i<=amount;i++) {
            min = Integer.MAX_VALUE;
            for (int j=0;j<coins.length;j++) {
                if (coins[j] <= i) {
                    if (mem[i-coins[j]]+1 < min) {
                        min = mem[i-coins[j]]+1;
                    }
                }
            }

            mem[i] = min;
        }

        if (mem[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return mem[amount];
    }

    public static void main(String [ ] args) {
        int [] nums = new int []{1, 2, 5};

        // 3
        System.out.println(coinChange(nums,11));

        nums = new int []{2};

        // -1
        System.out.println(coinChange(nums,3));
    }
}
