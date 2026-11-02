class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int i = 0;
        int j = n-1;

        int count = 0;
        while(i < j){
            count +=nums[j] - nums[i];
            i++;
            j--;
        }

        return count;
    }
}