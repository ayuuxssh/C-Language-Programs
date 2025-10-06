class Solution {
    public int maxCoins(int[] nums) {
         int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(nums[i]);
        list.add(1);
        list.addLast(1);
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp)
            Arrays.fill(row, 0);
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) {
                    continue;
                }
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int coins = list.get(i - 1) * list.get(k) * list.get(j + 1) + dp[i][k-1]+dp[k+1][j] ;
                    max = Math.max(max, coins);
                }
                 dp[i][j] = max;
            }
        }
        return dp[1][n];
    
    }
}
