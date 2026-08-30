class Solution {
    public int sumDecoded(long[] nums) {
        int n = nums.length;
        long sum = 0;
        long MOD = 1_000_000_007;

        for(long num : nums){
            long width = num % 10;
            num = num / 10;

            String temp = String.valueOf(Math.abs(num));
            long x = 0;

            for(int i = 1; i <= width; i++){
                x = x * 10 + (long)(temp.charAt(i - 1) - '0');
            }

            long y = 0;
            for(int i = (int)width + 1; i <= temp.length(); i++){
                y = y * 10 + (long)(temp.charAt(i - 1) - '0');
            }

            // Fast Power: O(log y)
            long ans = 1;
            x %= MOD;

            while(y > 0){
                if((y & 1) == 1){
                    ans = (ans * x) % MOD;
                }

                x = (x * x) % MOD;
                y /= 2;
            }

            sum = (sum + ans) % MOD;
        }

        return (int)sum;
    }
}