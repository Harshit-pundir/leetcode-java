import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals[i][0];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];

            int low = 0;
            int high = n - 1;
            int index = -1;

            
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (arr[mid][0] >= end) {
                    index = arr[mid][1];
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            ans[i] = index;
        }

        return ans;
    }
}