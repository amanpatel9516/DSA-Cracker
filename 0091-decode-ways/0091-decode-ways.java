class Solution {

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(0, s, dp);
    }

    private int solve(int p, String s, int[] dp) {

        if (p == s.length())
            return 1;

        if (s.charAt(p) == '0')
            return 0;

        if (dp[p] != -1)
            return dp[p];

        int ans = solve(p + 1, s, dp);

        if (p < s.length() - 1 &&
            (s.charAt(p) == '1' ||
            (s.charAt(p) == '2' && s.charAt(p + 1) <= '6'))) {

            ans += solve(p + 2, s, dp);
        }

        return dp[p] = ans;
    }
}