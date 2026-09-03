class Solution {
    public boolean uniformArray(int[] nums1) {
        int mn = nums1[0];
        boolean hasOdd = false;
        for (int num : nums1) {
            if (num < mn) {
                mn = num;
            }
            if ((num & 1) == 1) {
                hasOdd = true;
            }
        }
        if ((mn & 1) == 1) {
            return true;
        }
        return !hasOdd;
    }
}