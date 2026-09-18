class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        // Find first and last occurrence
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';

            first[ch] = Math.min(first[ch], i);
            last[ch] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Find valid intervals
        for (int c = 0; c < 26; c++) {

            if (last[c] == -1)
                continue;

            int start = first[c];
            int end = last[c];

            boolean valid = true;

            for (int i = start; i <= end; i++) {

                int ch = s.charAt(i) - 'a';

                // This character started before our substring
                if (first[ch] < start) {
                    valid = false;
                    break;
                }

                // Need to include all occurrences of this character
                end = Math.max(end, last[ch]);
            }

            if (valid) {
                intervals.add(new int[]{start, end});
            }
        }

        // Sort by ending position
        intervals.sort((a, b) -> a[1] - b[1]);

        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        // Greedy: choose earliest ending interval
        for (int[] interval : intervals) {

            int start = interval[0];
            int end = interval[1];

            if (start > prevEnd) {
                ans.add(s.substring(start, end + 1));
                prevEnd = end;
            }
        }

        return ans;
    }
}