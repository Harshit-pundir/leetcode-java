class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        int n = s.length();

        int[] hashArr = new int[256];
        Arrays.fill(hashArr, -1);

        int ans = 0;

        while (r < n) {
            char ch = s.charAt(r);

            if (hashArr[ch] >= l) {
                l = hashArr[ch] + 1;
            }

            int maxLen = r - l + 1;
            ans = Math.max(ans, maxLen);

            hashArr[ch] = r;
            r++;
        }

        return ans;
    }
}