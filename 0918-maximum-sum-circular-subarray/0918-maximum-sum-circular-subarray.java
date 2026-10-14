class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int minSum = nums[0];

        int currSum = nums[0];
        int currMin = nums[0];

        int total = nums[0];

        for(int i = 1; i < n; i++){
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(currSum,maxSum);

            currMin = Math.min(currMin + nums[i], nums[i]);
            minSum = Math.min(currMin , minSum);
            total += nums[i];
        }

        if(maxSum < 0) return maxSum;

        return Math.max(maxSum , total-minSum);
    }
}