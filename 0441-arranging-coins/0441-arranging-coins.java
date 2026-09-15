class Solution {
    public int arrangeCoins(int n) {
        int count = 0;
        long sum = 0;
        for(int i =1; i <= n; i++){
            if((long)sum + i <= n){
                sum +=i;
                count++;
            }else break;
        }

        return count;
    }
}