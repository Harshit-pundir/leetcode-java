class Solution {
    public int dominantIndex(int[] nums) {
        int maxInd = 0;
        for(int i =0; i<nums.length; i++){
            if(nums[maxInd] < nums[i]){
                maxInd = i;
            }
        }

        for(int num : nums){
            if(num != nums[maxInd] && num * 2 > nums[maxInd]) return -1;
        }

        return maxInd;
    }
}