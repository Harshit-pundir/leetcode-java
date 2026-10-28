class Solution {
    public long getDescentPeriods(int[] prices) {
        long count = 0;
        int n = prices.length;
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (right > 0 && prices[right - 1] - prices[right] != 1) {
                left = right;
            }

            count += right - left + 1;
        }

        return count;
    }
}