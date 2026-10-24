class Solution {
    public int maxSubArray(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    public int solve(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        int leftSum = solve(nums, left, mid);
        int rightSum = solve(nums, mid + 1, right);
        int crossSum = cross(nums, left, mid, right);

        return Math.max(leftSum, Math.max(rightSum, crossSum));
    }

    public int cross(int[] nums, int left, int mid, int right) {
        int sum = 0;
        int leftMax = Integer.MIN_VALUE;

        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftMax = Math.max(leftMax, sum);
        }

        sum = 0;
        int rightMax = Integer.MIN_VALUE;

        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightMax = Math.max(rightMax, sum);
        }

        return leftMax + rightMax;
    }
}