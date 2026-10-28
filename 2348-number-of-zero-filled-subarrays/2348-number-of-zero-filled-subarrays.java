class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long count = 0;

        int right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                right++;  // Fix: increment right
                continue;
            }

            int j = right;
            while (j < n && nums[j] == 0) j++;

            long len = j - right;
            count += len * (len + 1) / 2; 

            right = j;
        }

        return count;
    }
}