import java.util.*;

class Solution {

    class Job {
        int start, end, profit;

        Job(int s, int e, int p) {
            start = s;
            end = e;
            profit = p;
        }
    }

    Job[] jobs;
    Integer[] dp;

    public int solve(int idx) {
        if (idx == jobs.length)
            return 0;

        if (dp[idx] != null)
            return dp[idx];

        // Skip current job
        int notTake = solve(idx + 1);

        // Find next compatible job
        int next = binarySearch(jobs[idx].end);

        // Take current job
        int take = jobs[idx].profit + solve(next);

        return dp[idx] = Math.max(take, notTake);
    }

    private int binarySearch(int target) {
        int l = 0;
        int r = jobs.length - 1;
        int ans = jobs.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (jobs[mid].start >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;
        jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> a.start - b.start);

        dp = new Integer[n];

        return solve(0);
    }
}