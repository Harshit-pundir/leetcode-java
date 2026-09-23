class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int i = 0;
        int j = 1;

        while(j < n){
            int min = Math.min(nums[i] , nums[j]);
            ans += min;
            i+=2;
            j+=2;
        }

        return ans;
    }
}