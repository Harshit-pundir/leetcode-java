class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];

            int minStart = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < n; j++) {
                int start = intervals[j][0];

                if (start >= end && start < minStart) {
                    minStart = start;
                    index = j;
                }
            }

            ans[i] = index;
        }

        return ans;
    }
}