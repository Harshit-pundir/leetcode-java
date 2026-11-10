class Solution {
    String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public void solve(int idx, String digits, StringBuilder res,
                      List<String> ans) {

        if(idx == digits.length()){
            ans.add(res.toString());
            return;
        }

        String str = map[digits.charAt(idx) - '0'];

        for(int i = 0; i < str.length(); i++){

            res.append(str.charAt(i));

            solve(idx + 1, digits, res, ans);

            res.deleteCharAt(res.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if(digits.length() == 0) return ans;

        solve(0, digits, new StringBuilder(), ans);

        return ans;
    }
}
