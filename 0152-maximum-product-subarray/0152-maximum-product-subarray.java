class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];

        for(int i =0; i<nums.length; i++){
            int mul = 1;
            for(int j = i; j<nums.length; j++){
                mul *= nums[j];
                ans = Math.max(ans,mul);
            }

        }

        return ans;
    }
}