class Solution {
    
    public int solve(String text , int i , String text2 , int j,int[][] dp){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(text.charAt(i) == text2.charAt(j)) return dp[i][j] = 1 + solve(text, i-1, text2, j-1, dp);

        return dp[i][j] = Math.max(solve(text,i-1,text2,j,dp) , solve(text , i , text2,j-1,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return solve(text1,n-1,text2 , m-1,dp);
    }
}