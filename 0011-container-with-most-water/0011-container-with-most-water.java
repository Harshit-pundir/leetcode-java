class Solution {
    public int maxArea(int[] height) {
        int i =0;
        int j = height.length-1;
        int maxArea = Integer.MIN_VALUE;

        while(i <= j){
            int minHeight = Math.min(height[i] , height[j]);
            int ht = j - i;

            maxArea = Math.max(maxArea, minHeight * ht);
            if(height[i] <= height[j]) i++;
            else j--;
        }

        return maxArea;
    }
}