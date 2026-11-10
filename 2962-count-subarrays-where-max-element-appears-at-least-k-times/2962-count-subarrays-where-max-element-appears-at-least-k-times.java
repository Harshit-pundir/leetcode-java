class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int freq = 0;

        for(int num : nums){
            max = Math.max(num, max);
        }

        int n = nums.length;
        int left = 0;
        long count = 0;

        for(int right = 0; right < n; right++){
            int num = nums[right];

            if(num == max) freq++;

            while(freq >= k){
                count += n - right;

                if(nums[left] == max) freq--;
                left++;
            }
        }

        return count;
    }
}