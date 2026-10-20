class Solution {
    public int solve(int i, int n, int count) {
        if (n == 0) return count >= 2 ? 1 : 0;
        if (n < 0 || i > n) return 0;

        int take = 0;
        if (i <= n) {
            int res = solve(i, n - i, count + 1);
            if (res > 0) take = i * res;
        }

        int notTake = solve(i + 1, n, count);

        return Math.max(take, notTake);
    }

    public int integerBreak(int n) {
        return solve(1, n, 0);
    }
}