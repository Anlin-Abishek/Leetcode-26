class Solution {
    int[][] dp = new int[501][501];

    int solve(int i, int j, int[] nums1, int[] nums2) {
        if (i >= nums1.length || j >= nums2.length)
            return (int)-1e9;

        if (dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];

        int ans = Integer.MIN_VALUE;

        ans = Math.max(
                ans,
                nums1[i] * nums2[j] +
                Math.max(0, solve(i + 1, j + 1, nums1, nums2))
        );

        ans = Math.max(ans, solve(i + 1, j, nums1, nums2));
        ans = Math.max(ans, solve(i, j + 1, nums1, nums2));

        return dp[i][j] = ans;
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        for (int i = 0; i < 501; i++) {
            for (int j = 0; j < 501; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return solve(0, 0, nums1, nums2);
    }
}
