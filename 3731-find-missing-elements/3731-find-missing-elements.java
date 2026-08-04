class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i =0; i<nums.length-1; i++){
            int num = nums[i] + 1;
            while(num != nums[i+1]){
                res.add(num);
                num++;
            } 
        }

        return res;
    }
}