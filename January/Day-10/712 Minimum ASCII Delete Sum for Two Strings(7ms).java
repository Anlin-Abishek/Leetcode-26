class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        char[] a = s1.toCharArray(); char[] b = s2.toCharArray();
        int n = a.length; int m = b.length;
        int[][] dp = new int[n + 1][m + 1];
        int total = 0;
        for(char c: a) total += (int) c;
        for(char c: b) total += (int) c;
        for(int i =  n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(a[i] == b[j]){
                    dp[i][j] += dp[i + 1][j + 1] + (int) a[i];
                } else {
                    dp[i][j] = Math.max(dp[i +1][j], dp[i][j + 1]);
                }

            }
        }
        return -dp[0][0] * 2 + total;
    }
}
