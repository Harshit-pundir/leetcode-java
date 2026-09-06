class Solution {
    public int largestAltitude(int[] gain) {
        int val = 0;
        int ans = 0;

        for(int num : gain){
            val += num;
            ans = Math.max(val,ans);
        }

        return ans;
    }
}