class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefixArr = new int[n];

        prefixArr[0] = nums[0];
        for(int i =1; i<n; i++){
            prefixArr[i] = Math.max(prefixArr[i-1],nums[i]);
        }

        int[] suffixArr = new int[n];
        suffixArr[n-1] = nums[n-1];

        for(int j = n-2; j >=0; j-- ){
            suffixArr[j] = Math.min(suffixArr[j+1],nums[j]);
        }

        
        for(int i =0; i<n; i++){
            int max = prefixArr[i];
            int min = suffixArr[i];
            int diff = max - min;
            if(diff <= k) return i;
        }
        return -1;
    }
}