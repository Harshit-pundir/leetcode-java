class Solution {
    public int minRange(int a, int b, int c) {
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));

        int mid = a + b + c - min - max;

        if (max > min + mid) {
            return mid;
        }

        return max - min;
    }
}
