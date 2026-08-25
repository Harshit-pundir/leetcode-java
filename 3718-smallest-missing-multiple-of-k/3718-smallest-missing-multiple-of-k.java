class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        for(int i = 0; i <= nums.length; i++){
            if(!set.contains(k*(i+1))) return k * (i+1);
        }

        return -1;
    }
}