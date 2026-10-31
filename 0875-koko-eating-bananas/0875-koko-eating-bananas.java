class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int ans = 0;
        int max = piles[0];

        for(int num : piles) max = Math.max(num,max);

        int low = 1;
        int high = max;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(checkHour(piles,mid) <= h){
                high = mid-1;
                ans = mid;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }

    public int checkHour(int[] piles , int currHour ){
        int count = 0;

        for(int num : piles){
            count += Math.ceil((double)num/currHour);
        }

        return count;
    }
}