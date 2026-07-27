class Solution {
    public int maxProduct(int[] nums) {
        int max2 = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            if(num >= max){
                max2 = max;
                max = num;
            }else if(num > max2){
                max2 = num;
            }
        }

        return (max-1) *(max2 -1);
    }
}