class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int n = nums.length;
        int left = 0;

        for(int right = 0; right < n; right++){
            sum += nums[right];
            while(sum >= target){
                minLen = Math.min(right-left+1,minLen);
                sum -= nums[left];
                left++;
            }

        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}