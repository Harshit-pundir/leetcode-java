class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] < k) low = mid+1;
            else high = mid-1;
        }

        return low;
    }
}