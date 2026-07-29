class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int n = nums.length;
        int closetSum = 0;
        int diff = Integer.MAX_VALUE;

        for(int i =0; i < n-2; i++){
            for(int j = i+1; j <n-1; j++){
                for(int k = j+1; k <n; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == target) return sum;
                    if(diff >  Math.abs(target - sum)){
                        closetSum = sum;
                        diff = Math.abs(target - sum);
                    }
                }
            }
        }

        return closetSum;
    }
}