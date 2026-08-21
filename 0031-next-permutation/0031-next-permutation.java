class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2 , j = n-1;

        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i >= 0){
            while(j >= 0 && nums[j] <= nums[i]){
            j--;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        
        }

        
        reverse(nums,i+1,n-1);
    }
    public void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}