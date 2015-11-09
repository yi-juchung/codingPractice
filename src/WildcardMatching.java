public class WildcardMatching {
    static public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;

        boolean [][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        for (int i=1;i<=s.length();i++) {
            dp[i][0] = false;
        }

        for (int i=1;i<=p.length();i++) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-1];
            } else {
                dp[0][i] = false;
            }
        }

        for (int i=1;i<=s.length();i++) {
            for (int j=1;j<=p.length();j++) {
                Character c = p.charAt(j-1);
                if (c == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else if (c == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j-1] && s.charAt(i-1) == p.charAt(j-1);
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String [ ] args) {

        System.out.print(isMatch("a","*a*"));
    }
}
