class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int i = 1;

        for(int num : nums){
            if(n % i == 0){
                sum += (num * num);
            }
            i++;
        }

        return sum;
    }
}