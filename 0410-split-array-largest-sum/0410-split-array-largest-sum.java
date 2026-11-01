class Solution {
    public int splitArray(int[] nums, int k) {
       int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : nums){
            sum += num;
            max = Math.max(num, max);
        }

        int low = max;
        int high = sum;

        while(low < high){
            int mid = low + (high - low)/2;

            if(isPossible(nums, mid, k)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean isPossible(int[] arr, int maxReach, int k){
        int count = 1;
        int currReach = 0;

        for(int num : arr){
            if(currReach + num <= maxReach){
                currReach += num;
            }else{
                count++;
                currReach = num;
            }
        }

        return count <= k;
    }
}