class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        if(k == 1){
            int largest = Integer.MIN_VALUE;
            for(int num : map.keySet()){
                if(map.get(num) == 1) largest = Math.max(largest,num);
            }
            return (largest == Integer.MIN_VALUE) ? -1 : largest ;
        }else if(k == n){
            int largest = Integer.MIN_VALUE;
            for(int num : map.keySet()) largest = Math.max(largest,num);
            return (largest == Integer.MIN_VALUE) ? -1 : largest ;
        }

        boolean first = map.get(nums[0]) == 1;
        boolean last = map.get(nums[n - 1]) == 1;

        if(first && last)
            return Math.max(nums[0], nums[n - 1]);

        if(first)
            return nums[0];

        if(last)
            return nums[n - 1];

        return -1;
        
    }
}