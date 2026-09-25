class Solution {
    public int mostFrequentEven(int[] nums) {
        int maxFreq = 0;
        int maxEven = -1;
        int n = nums.length;
        if(n == 1 && nums[0] % 2 == 0) return nums[0];
        int count = 1;

        Arrays.sort(nums);
        for(int i = 1; i < n; i++){
            if(nums[i] != nums[i-1]){
                if(nums[i-1] % 2 == 0){
                    if(count > maxFreq){
                        maxFreq = count;
                        maxEven = nums[i-1];
                    }
                }
                count = 1;
            }
            else count++;
        }
        if (nums[n - 1] % 2 == 0) {

            if (count > maxFreq) {
                maxFreq = count;
                maxEven = nums[n - 1];
            }
        }

        return maxEven;
    }
}