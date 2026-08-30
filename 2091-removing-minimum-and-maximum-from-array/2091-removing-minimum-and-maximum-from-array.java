class Solution {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        if(n == 1) return 1;

        for(int num : nums){
            max = Math.max(num,max);
            min = Math.min(num,min);
        }

        int minDist = Integer.MAX_VALUE;
        int found = 0;
        int count =0;
        for(int num : nums){
            if(num == max) found++;
            if(num == min) found++;
            count++;
            if(found == 2) break;
        }

        minDist = Math.min(minDist,count);
        count =0;
        found =0;

        for(int i = n-1; i >= 0; i--){
            if(nums[i] == max) found++;
            if(nums[i] == min) found++;
            count++;
            if(found == 2) break;
        }

        minDist = Math.min(minDist,count);

        count =0;
        found =0;

        for(int num : nums){
            if(num == max) found++;
            if(num == min) found++;
            count++;
            if(found >= 1) break;
        }
        found = 0;
        for(int i = n-1; i >= 0; i--){
            if(nums[i] == max) found++;
            if(nums[i] == min) found++;
            count++;
            if(found >= 1) break;
        }
        minDist = Math.min(minDist,count);
        return minDist;
    }
}