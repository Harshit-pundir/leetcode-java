class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        int n = nums.length;
        int[] ans = new int[n];

        int idx = 0;

        // Smaller elements
        for (int num : nums) {
            if (num < pivot) {
                ans[idx++] = num;
            }
        }

        // Equal elements
        for (int num : nums) {
            if (num == pivot) {
                ans[idx++] = num;
            }
        }

        // Greater elements
        for (int num : nums) {
            if (num > pivot) {
                ans[idx++] = num;
            }
        }

        return ans;
    }
}