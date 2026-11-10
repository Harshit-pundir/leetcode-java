class Solution {
    public void solve(int open , int close,int n,String res,List<String> ans){
        if(close == n){
            ans.add(res);
            return;
        }

        if(open < n){
            solve(open+1,close,n,res+"(",ans);
        }
        if(close < open){
            solve(open,close+1,n,res+")",ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(0,0,n,"",ans  );
        return ans;
    }
}