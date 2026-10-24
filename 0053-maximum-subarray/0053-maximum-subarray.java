class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int ans = nums[0];
        int n = nums.length;

        for(int i = 1; i < n; i++){
            int num = nums[i];
            sum = Math.max(num,sum+num);
            ans = Math.max(ans,sum);
        }

        return ans;
    }
}