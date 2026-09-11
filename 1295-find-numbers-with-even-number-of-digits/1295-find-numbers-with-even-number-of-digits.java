class Solution {
    public int findNumbers(int[] nums) {
        int ans =0;
        for(int num : nums){
            int count =0;
            int temp = num;
            while(num > 0){
                num /= 10;
                count++;
            }
            if(count != 0 && count % 2 == 0) ans++;
        }

        return ans;
    }
}