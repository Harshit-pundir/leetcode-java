class Solution {
    public void solve(int idx , int currSum , int[] candidates, int target, List<Integer> res, List<List<Integer>> ans){
        if(currSum == target){
            ans.add(new ArrayList<>(res));
            return;
        }
        if(idx >= candidates.length) return;
        solve(idx+1,currSum ,candidates, target , res , ans);
        if(currSum + candidates[idx] <= target ){
            res.add(candidates[idx]);
            solve(idx,currSum + candidates[idx] ,candidates, target , res , ans);
            res.remove(res.size()-1);
        }
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0,0,candidates,target,new ArrayList<>(),ans);
        return ans;
    }
}