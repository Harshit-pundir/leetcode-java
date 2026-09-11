class Solution {
    public boolean canAliceWin(int[] nums) {
        int aliceSum = 0;
        int bobSum = 0;

        
        for(int num : nums){
            if(num < 10){
                aliceSum += num;
                
            } 
            else{
                bobSum += num;
                
            } 
        }

        if(aliceSum != bobSum ) return true;
        
        return false;
    }
}