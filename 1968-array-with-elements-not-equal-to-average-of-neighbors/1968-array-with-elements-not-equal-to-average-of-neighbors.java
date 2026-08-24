class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = nums.clone();
        Arrays.sort(ans);
        int i =0;
        int n = ans.length;
        int j = n-1;

        int k = 0;
        while(k < n){
            nums[k++] = ans[i++];
            if(k < n) nums[k++] = ans[j--];
        }


        return nums;
    }
}