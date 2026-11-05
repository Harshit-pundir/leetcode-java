class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return checkDiff(nums,k) - checkDiff(nums,k-1);
    }
    public int checkDiff(int[] nums , int k){
        int n = nums.length;
        int ans = 0;
        int count = 0;
        int left = 0;

        for(int right = 0; right < n; right++){
            if(nums[right] % 2 != 0) count++;

            while(count > k){
                int num = nums[left];
                if(num % 2 != 0){
                    count--;
                }
                left++;
            } 

            ans += right - left +1;
        }

        return ans;
    }
}