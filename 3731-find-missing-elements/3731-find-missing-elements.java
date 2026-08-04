class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num : nums){
            max = Math.max(num,max);
            min = Math.min(num,min);
            set.add(num);
        }

        for(int i = min; i<=max; i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }
}