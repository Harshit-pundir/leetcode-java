class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
       int n = items.length;

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {

            int factor = items[i][0];
            int price = items[i][1];

            int free = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % factor == 0) {
                    free++;
                }
            }

            int[] curr = new int[budget + 1];
            Arrays.fill(curr, -1000000);

            for (int b = price; b <= budget; b++) {

                
                int first = dp[b - price] + 1 + free;

                int more = curr[b - price] + 1;

                curr[b] = Math.max(first, more);
            }

            for (int b = 0; b <= budget; b++) {
                dp[b] = Math.max(dp[b], curr[b]);
            }
        }

        return dp[budget];
    }
}