class Solution {
    public int majorityElement(int[] nums) {
        int number = nums[0];
        int count = 0;
        int n = nums.length;

        for(int num : nums){
            if(count == 0){
                number = num;
                count++;
            }
            else if(number == num) count++;
            else count--;
        }
        if(count >= n/2) return number;
        return number;
    }
}