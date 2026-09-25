class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = intervals.length;
        long count = 0;

        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];

            int low = i + 1;
            int high = n - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (intervals[mid][0] <= end) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            count += low - (i + 1);
        }

        return count;
    }
}