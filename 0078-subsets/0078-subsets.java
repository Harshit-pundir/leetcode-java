class Solution {
    public void solve(int[] nums, int idx, ArrayList<Integer> temp , List<List<Integer>> ans){
        if(idx == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        solve(nums,idx+1,temp , ans);
        temp.remove(temp.size()-1);
        solve(nums,idx+1,temp,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums,0,new ArrayList<>() , ans);
        return ans;
    }
}