class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            long prod = 1;
            long gcd = 0;
            long lcm = 1;

            for(int j = i; j < n; j++) {
                prod *= nums[j];

                gcd = findGcd(gcd, nums[j]);

                lcm = (lcm * nums[j]) / findGcd(lcm, nums[j]);

                if(prod == lcm * gcd) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    public long findGcd(long a, long b) {
        if(b == 0) return a;

        return findGcd(b, a % b);
    }
}
