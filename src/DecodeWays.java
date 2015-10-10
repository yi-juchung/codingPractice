public class DecodeWays {
    static public int numDecodings(String s) {
        if (s.length() < 1)
            return 0;
        if (s.length() < 2)
            return (s.charAt(0) != '0')?1:0;

        int [] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) != '0')?1:0;

        for (int i=2;i<s.length()+1;i++) {
            if (isValid(s.substring(i-1,i))) {
                dp[i] += dp[i-1];
            }

            if (isValid(s.substring(i-2,i))) {
                dp[i] += dp[i-2];
            }
        }

        return dp[s.length()];

    }

    static public boolean isValid(String s) {
        if (s.charAt(0) == '0')
            return false;

        int i = Integer.parseInt(s);

        return i < 27 && i > 0;
    }

    public static void main(String [ ] args) {
        System.out.println(numDecodings("12"));
    }
}
