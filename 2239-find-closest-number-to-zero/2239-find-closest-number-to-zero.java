class Solution {
    public int findClosestNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if(nums.length == 1) return nums[0];

        for(int num : nums){
            set.add(num);
        }
        int i = 0;
        int j = 0;

        while(true){
            if(set.contains(i)) return i;
            if(set.contains(j)) return j;
            i++;
            j--;
        }

       
    }
}