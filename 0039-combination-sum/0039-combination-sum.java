class Solution {
    public void solver(int[] candidates, int target, int currSum, int idx, List<Integer> list, List<List<Integer>> ans) {
        if(currSum == target){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(idx == candidates.length || currSum > target) return;

        // pick
        if(currSum + candidates[idx] <= target){
            list.add(candidates[idx]);
            solver(candidates,target,currSum + candidates[idx],idx,list,ans);
            list.remove(list.size()-1);
        }

        //not pick
        solver(candidates, target,currSum,idx+1,list,ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solver(candidates,target,0,0,new ArrayList<>() , ans);
        return ans;
    }
}