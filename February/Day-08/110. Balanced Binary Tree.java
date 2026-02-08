class Solution {
    private int height(TreeNode root, boolean[] ans) {
        if (root == null)
            return 0;

        int leftHeight = 1 + height(root.left, ans);
        int rightHeight = 1 + height(root.right, ans);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            ans[0] = false;
            return 0;
        }
        return Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        boolean[] ans = new boolean[]{true};
        height(root, ans);
        return ans[0];
    }
}
