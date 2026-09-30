class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int i =0;
        for(int num : nums){
            ans[i++] = num * num;
        }
        Arrays.sort(ans);
        return ans;
    }
}