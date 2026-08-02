class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int evenIdx = 0;
        int oddIdx = 1;

        int n = nums.length;
        int[] ans = new int[n];

        for(int num : nums){
            if(num % 2 != 0){
                ans[oddIdx] = num;
                oddIdx += 2;
            } 
            else{
                ans[evenIdx] = num;
                evenIdx += 2;
            } 
        }

        return ans;
    }
}