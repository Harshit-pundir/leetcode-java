class Solution {
    public int smallestNumber(int n, int t) {
        
        for(int i = n; i <= n * 10; i++){
            int temp = i;
            int prod = 1;

            while(temp != 0){
                int digit = temp % 10;
                temp /= 10;
                prod *= digit;
            }
            if(prod % t == 0) return i;
        }

        return -1;
    }
}