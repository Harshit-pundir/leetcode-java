class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int left = 0;
        int ans = 0;

        int[] count = new int[3];

        for(int right = 0; right < n; right++){
            char ch = s.charAt(right);
            count[ch-'a']++;

            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                ans += n - right;

                count[s.charAt(left)-'a']--;
                left++;
            }
        }

        return ans;
    }
}