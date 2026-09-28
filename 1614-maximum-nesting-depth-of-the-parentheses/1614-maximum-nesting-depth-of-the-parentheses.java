class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int open = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(') open++;
            else if(ch ==')') open--;

            ans = Math.max(open,ans);
        }

        return ans;
    }
}