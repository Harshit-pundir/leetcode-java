class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        for(int num : nums){
            min = Math.min(min,num);
        } 


        for(int num : nums){
            count += (long)num-min;
        }
    
        return (int)count;
    }
}