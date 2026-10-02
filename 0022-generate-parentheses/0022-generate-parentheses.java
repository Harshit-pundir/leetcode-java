class Solution {
    public void balancedParenthesis(char[] str, int pos, int n , int open , int close, List<String> ans) {
        if (close == n) {
            ans.add(new String(str));
            return;
        }

        if (open < n) {
            str[pos] = '(';
            balancedParenthesis(str, pos + 1, n, open + 1, close, ans);
        }

        if (open > close) {
            str[pos] = ')';
            balancedParenthesis(str, pos + 1, n, open, close + 1, ans);
        }
    }

    public List<String> generateParenthesis(int n) {
        char[] str = new char[n * 2];
        List<String> ans = new ArrayList<>();
        balancedParenthesis(str, 0, n, 0, 0, ans);
        return ans;
    }
}
