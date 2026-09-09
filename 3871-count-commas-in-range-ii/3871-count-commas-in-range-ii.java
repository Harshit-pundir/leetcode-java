class Solution {
    public long countCommas(long n) {
        long ans = 0;

        if (n >= 1_000) {
            long end = Math.min(n, 999_999L);
            ans += end - 1_000 + 1;
        }

        if (n >= 1_000_000) {
            long end = Math.min(n, 999_999_999L);
            ans += (end - 1_000_000 + 1) * 2;
        }

        if (n >= 1_000_000_000L) {
            long end = Math.min(n, 999_999_999_999L);
            ans += (end - 1_000_000_000L + 1) * 3;
        }

        if (n >= 1_000_000_000_000L) {
            long end = Math.min(n, 999_999_999_999_999L);
            ans += (end - 1_000_000_000_000L + 1) * 4;
        }

        if (n >= 1_000_000_000_000_000L) {
            ans += (n - 1_000_000_000_000_000L + 1) * 5;
        }

        return ans;
    }
}