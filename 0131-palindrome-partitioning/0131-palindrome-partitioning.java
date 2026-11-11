class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public void solve(int idx, String s, List<String> res, List<List<String>> ans) {

        if(idx == s.length()) {
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i = idx; i < s.length(); i++) {

            String temp = s.substring(idx, i + 1);

            if(isPalindrome(temp)) {
                res.add(temp);

                solve(i + 1, s, res, ans);

                res.remove(res.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        solve(0, s, new ArrayList<>(), ans);

        return ans;
    }
}
