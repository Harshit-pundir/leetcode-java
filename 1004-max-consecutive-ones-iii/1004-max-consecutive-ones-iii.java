class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int zeroes = 0;
        int maxLen = 0;
        int left = 0;

        for(int right = 0; right < n; right++){
            zeroes += (nums[right] == 0) ? 1 : 0;

            while(zeroes > k){
                if(nums[left] == 0) zeroes--;
                left++;
            }

            maxLen = Math.max(maxLen , right - left+1);
        }
        return maxLen;
    }
}