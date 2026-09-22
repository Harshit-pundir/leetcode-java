class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        // Sort by width ascending
        // If width is same, height descending
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        // LIS on heights
        int[] dp = new int[envelopes.length];
        int len = 0;

        for (int[] envelope : envelopes) {
            int height = envelope[1];

            int low = 0;
            int high = len;

            // Binary search
            while (low < high) {
                int mid = low + (high - low) / 2;

                if (dp[mid] < height) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            dp[low] = height;

            if (low == len) {
                len++;
            }
        }

        return len;
    }
}