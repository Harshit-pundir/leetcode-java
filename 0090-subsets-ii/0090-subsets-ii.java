class Solution {
    public void solve(int idx, int[] nums, List<Integer> res , HashSet<List<Integer>> ans){
        if(idx == nums.length){
            List<Integer> temp = new ArrayList<>(res);
            Collections.sort(temp);
            ans.add(temp);
            return;
        }

        solve(idx+1,nums,res,ans);
        res.add(nums[idx]);
        solve(idx+1,nums,res,ans);
        res.remove(res.size()-1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet<>();
        solve(0,nums,new ArrayList<>() , ans);
        return new ArrayList<>(ans);
    }
}