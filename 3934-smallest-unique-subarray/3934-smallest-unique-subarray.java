class Solution {

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        if (n == 1) return 1;

        int[] sa = buildSuffixArray(nums);
        int[] lcp = buildLCP(nums, sa);

        int ans = n;

        for (int i = 0; i < n; i++) {
            int maxLCP = 0;

            if (i > 0) {
                maxLCP = Math.max(maxLCP, lcp[i]);
            }

            if (i < n - 1) {
                maxLCP = Math.max(maxLCP, lcp[i + 1]);
            }

            if (maxLCP < n - sa[i]) {
                ans = Math.min(ans, maxLCP + 1);
            }
        }

        return ans;
    }

    private int[] buildSuffixArray(int[] nums) {
        int n = nums.length;

        Integer[] sa = new Integer[n];
        int[] rank = nums.clone();

        for (int i = 0; i < n; i++) {
            sa[i] = i;
        }

        for (int k = 1; k < n; k *= 2) {
            final int len = k;
            final int[] currentRank = rank;

            Arrays.sort(sa, (a, b) -> {
                if (currentRank[a] != currentRank[b]) {
                    return Integer.compare(currentRank[a], currentRank[b]);
                }

                int ra = a + len < n ? currentRank[a + len] : -1;
                int rb = b + len < n ? currentRank[b + len] : -1;

                return Integer.compare(ra, rb);
            });

            int[] newRank = new int[n];
            newRank[sa[0]] = 0;

            for (int i = 1; i < n; i++) {
                int a = sa[i - 1];
                int b = sa[i];

                boolean different = currentRank[a] != currentRank[b];

                int ra = a + len < n ? currentRank[a + len] : -1;
                int rb = b + len < n ? currentRank[b + len] : -1;

                if (different || ra != rb) {
                    newRank[b] = newRank[a] + 1;
                } else {
                    newRank[b] = newRank[a];
                }
            }

            rank = newRank;

            if (rank[sa[n - 1]] == n - 1) break;
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = sa[i];
        }

        return result;
    }

    private int[] buildLCP(int[] nums, int[] sa) {
        int n = nums.length;

        int[] rank = new int[n];
        int[] lcp = new int[n];

        for (int i = 0; i < n; i++) {
            rank[sa[i]] = i;
        }

        int h = 0;

        for (int i = 0; i < n; i++) {
            int r = rank[i];

            if (r == 0) continue;

            int j = sa[r - 1];

            while (i + h < n && j + h < n &&
                   nums[i + h] == nums[j + h]) {
                h++;
            }

            lcp[r] = h;

            if (h > 0) h--;
        }

        return lcp;
    }
}