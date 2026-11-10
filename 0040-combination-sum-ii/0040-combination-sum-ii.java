
class Solution {
    public void solve(int idx, int currSum, int[] candidates, int target,
                      List<Integer> res, List<List<Integer>> ans) {

        if(currSum == target){
            ans.add(new ArrayList<>(res));
            return;
        }

        if(idx >= candidates.length || currSum > target) return;

        // Not Pick - skip duplicate elements
        int next = idx + 1;
        while(next < candidates.length &&
              candidates[next] == candidates[idx]){
            next++;
        }

        solve(next, currSum, candidates, target, res, ans);

        // Pick
        if(currSum + candidates[idx] <= target){
            res.add(candidates[idx]);

            solve(idx + 1, currSum + candidates[idx],
                  candidates, target, res, ans);

            res.remove(res.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        solve(0, 0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }
}
