public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 0 , high = n;

        while(low <= high){
            int mid = low + ( high - low)/2;
            int gs = guess(mid);

            if(gs == 0) return mid;
            else if(gs == -1) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}