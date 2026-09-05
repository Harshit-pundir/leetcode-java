class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int mxCandies = 0;
        for(int i =0; i<candies.length; i++){
            if(candies[i] > mxCandies){
                mxCandies = candies[i];
            }
        }

        for(int i =0; i<candies.length; i++){
            if(candies[i] + extraCandies >= mxCandies){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }

        return ans;
    }
}