class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 0;
        int prev = -1;
        int count = 0;

        for(int num : nums){
            if(num > prev ){
                count++;
            }else{
                inc = Math.max(inc,count);
                count = 1;
            }
            prev = num;
        }
        inc = Math.max(inc,count);
        int dec = 0;
        prev = Integer.MAX_VALUE;
        count = 0;

        for(int num : nums){
            if(num < prev ){
                count++;
            }else{
                dec = Math.max(dec,count);
                count = 1;
            }
            prev = num;
        }
        dec = Math.max(dec,count);
        return Math.max(inc,dec);
    }
}