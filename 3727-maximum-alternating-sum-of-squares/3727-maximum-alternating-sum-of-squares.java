class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0) nums[i] = -nums[i];
        }

        Arrays.sort(nums);
        int i = 0;
        int j = n-1;

        long sum = 0;

        while(i < j){
            sum += (nums[j] * nums[j]);
            j--;
            sum -= (nums[i] * nums[i]);
            i++;
        }

        if(n % 2 != 0) sum += (nums[j] * nums[j]);

        return sum;
    }
}