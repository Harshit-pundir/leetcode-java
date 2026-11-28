class Solution {
    public int minRange(int a, int b, int c) {
        int max = Math.max(a, b);
        int mid = Math.min(a, b);
        int min = -1;

        if (c > max) {
            min = mid;
            mid = max;
            max = c;
        } 
        else if (c > mid) {
            min = mid;
            mid = c;
        } 
        else {
            min = c;
        }

        return Math.min(mid, max - min);
    }
}
