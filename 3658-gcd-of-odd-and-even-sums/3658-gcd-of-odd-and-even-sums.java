class Solution {
    public int gcd(long sumOdd , long sumEven){
        if(sumEven == 0) return (int)sumOdd;
        return gcd(sumEven,sumOdd%sumEven);
    }
    public int gcdOfOddEvenSums(int n) {
        long sumOdd = 0;
        long sumEven = 0;

        int count =0;
        int i =1;

        while(count <= n){
            sumOdd += i;
            i+=2;
            count++;
        }

        count =0;
        i =0;

        while(count <= n){
            sumEven += i;
            i+=2;
            count++;
        }

        return gcd(sumOdd,sumEven)-1;
    }
}