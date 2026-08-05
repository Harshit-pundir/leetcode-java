class Solution {
    public int hammingWeight(int n) {
        int setbit = 0;
        while(n != 0){
            if((n & 1) == 1) setbit++;
            n >>>= 1;
        }
        
        return setbit;
    }
}