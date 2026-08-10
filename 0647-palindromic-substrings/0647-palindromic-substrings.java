class Solution {
    public int countSubstrings(String s) {

        int n = s.length();
        int c = 0;
        for (int i = 0; i < n; i++) {

            // odd center
            int l = i;
            int r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                c++;
                l--;
                r++;
            }

            // even center
             l = i;
             r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                c++;
                l--;
                r++;
            }
        }
        return c;
    }
}