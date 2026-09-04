class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        for(int i =0; i<n; i++){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            
            for(int idx =0; idx<= i && i < n; idx++){
                max = Math.max(nums[idx],max);
            }

            for(int j = i; j<=n-1; j++){
                 min = Math.min(nums[j],min);
            }
                int diff = max - min;
                if(diff <= k) return i;
                
            }

        return -1;
    }
}