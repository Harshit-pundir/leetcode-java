class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int n = nums.length;

        int pref = 1;
        int suffix = 1;

        for(int i =0; i<n; i++){
            if(suffix == 0) suffix = 1;
            if(pref == 0) pref = 1;


            pref *= nums[i];
            suffix *= nums[n-i-1];

        
            ans = Math.max(ans,Math.max(pref,suffix));
        }

        return ans;
    }
}