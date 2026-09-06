class Solution {
    public void moveZeroes(int[] nums) {
        int zeroes = 0;
        int j =0;

        for(int i =0; i<nums.length; i++){
            if(nums[i] == 0) zeroes++;
            else nums[j++] = nums[i];
        }

        while(zeroes-- > 0){
            nums[j++] = 0;
        }
    }
}