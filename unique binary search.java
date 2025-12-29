class Solution {
    static int[] dp;
    public static int num_trees(int n){
        if (n == 0 || n == 1) return 1;
        if (dp[n] != -1) return dp[n];
        int sum = 0;
        for (int root = 1; root <= n; root++){
            int left = num_trees(root - 1);
            int right = num_trees(n - root);
            sum += left * right;
        }
        return dp[n] = sum;
        }

    public int numTrees(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return num_trees(n);
    }
}
