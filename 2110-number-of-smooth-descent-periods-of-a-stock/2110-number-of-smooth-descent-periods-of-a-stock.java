class Solution {
    public long getDescentPeriods(int[] prices) {
        long count = 0;
        int n = prices.length;
        int left = 0;

        while (left < n) {
            int j = left + 1;

            while (j < n && prices[j - 1] - prices[j] == 1) {
                j++;
            }

            long len = j - left;
            count += len * (len + 1) / 2;

            left = j;
        }

        return count;
    }
}