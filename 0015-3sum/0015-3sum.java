class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        HashSet<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < n-1; i++){
            int left = i+1;
            int right = n-1;

            while(left < right){
                
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < 0) left++;
                else if(sum > 0) right--;
                else {
                    set.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                    
                }
            }
        }
        return new ArrayList<>(set);

    }
}