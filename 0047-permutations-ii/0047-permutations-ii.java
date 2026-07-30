class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        solve(nums,visited , new ArrayList<>() , ans);
        return ans;
    }

    public void solve(int[] nums,boolean[] visited , List<Integer> curr , List<List<Integer>> ans){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i =0; i<nums.length; i++){
            if(visited[i]) continue;

            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;

            visited[i] = true;
            curr.add(nums[i]);
            solve(nums , visited , curr , ans);
            curr.remove(curr.size()-1);
            visited[i] = false;
        }
    }
}