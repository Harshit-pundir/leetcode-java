class Solution {
    public int smallestIndex(int[] nums) {
        int i = 0;
        for(int num : nums){
            int sum = 0;
            while(num != 0){
                sum += num %10;
                num /= 10;
            }

            if(i == sum) return i;
            i++;
        }
        return -1;
    }
}