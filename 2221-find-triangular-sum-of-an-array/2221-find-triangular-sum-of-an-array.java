
class Solution {
    public int triangularSum(int[] nums) {
        int len = nums.length;
        while(len > 1){
            int[] newNums = new int[len-1];
            int k = 0;

            for(int i = 0; i < len-1; i++){
                newNums[k] = (nums[i] + nums[i+1]) % 10;
                k++;
            }

            len--;
            nums = newNums; 
        }

        return nums[0];
    }
}
