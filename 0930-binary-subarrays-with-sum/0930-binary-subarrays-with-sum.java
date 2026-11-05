class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return checkDiff(nums,goal) - checkDiff(nums,goal-1);
    }
    public int checkDiff(int[]  nums, int goal){
        int ans = 0;
        int n = nums.length;
        int left = 0;
        int sum = 0;

        for(int right = 0; right < n; right++){
            sum += nums[right];

            while(left <= right && sum > goal){
                sum -= nums[left];
                left++;
            }
            ans += right - left +1;

        }

        return ans;
    }
}