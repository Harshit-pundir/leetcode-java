class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        int[] ugly = new int[n];
        ugly[0] = 1;

        int p2 = 0 , p3 = 0 ,  p5 = 0;

        for(int i = 1; i < n; i++){
            int next2 = ugly[p2] * 2;
            int next3 = ugly[p3] * 3;
            int next5 = ugly[p5] * 5;

            int nextUgly = Math.min(next2 , Math.min(next3,next5));
            ugly[i]  = nextUgly;

            if(next2 == nextUgly) p2++;
            if(next3 == nextUgly) p3++;
            if(next5 == nextUgly) p5++;


        }

        return ugly[n-1]; 
    }
}