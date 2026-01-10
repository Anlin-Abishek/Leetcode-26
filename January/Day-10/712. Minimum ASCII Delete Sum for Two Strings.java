class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        if (s2.length() > s1.length()) {
            return minimumDeleteSum(s2, s1);
        }

        int n = s1.length();
        int m = s2.length();
        int[] dp = new int[m + 1];

        for (int j = 1; j <= m; j++) {
            dp[j] = dp[j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= n; i++) {
            int prev_diag = dp[0];
            
            dp[0] += s1.charAt(i - 1);

            for (int j = 1; j <= m; j++) {
                int temp = dp[j];

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = prev_diag;
                } else {
                    dp[j] = Math.min(
                        dp[j] + s1.charAt(i - 1),
                        dp[j - 1] + s2.charAt(j - 1)
                    );
                }
                prev_diag = temp;
            }
        }

        return dp[m];
    }
}
