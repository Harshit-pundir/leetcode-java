class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int ans = 0;

        int leftMax = 0, rightMax = 0;

        while (l <= r) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[l]);
                ans += leftMax - height[l];
                l++;
            } else {
                rightMax = Math.max(rightMax, height[r]);
                ans += rightMax - height[r];
                r--;
            }
        }
        return ans;
    }
}