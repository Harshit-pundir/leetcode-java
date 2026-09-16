class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if(n == 0 ) return 0;
        int low = 0;
        int high = n-1;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            int required = n - mid;

            if(citations[mid] >= required){
                ans = required;
                high = mid-1;
            }else low = mid+1;
        }

        return ans;
    }
}