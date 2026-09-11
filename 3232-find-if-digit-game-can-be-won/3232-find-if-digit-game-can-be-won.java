class Solution {
    public boolean canAliceWin(int[] nums) {
        int aliceSum = 0;
        int bobSum = 0;

        int alice2Sum = 0;
        int bob2Sum =0;
        for(int num : nums){
            if(num < 10){
                aliceSum += num;
                bob2Sum += num;
            } 
            else{
                bobSum += num;
                alice2Sum += num;
            } 
        }

        if(aliceSum > bobSum || alice2Sum > bob2Sum) return true;
        
        return false;
    }
}