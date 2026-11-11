
class Solution {
    public void solve(int idx, int[] nums, List<Integer> res, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(res));

        for(int i = idx; i < nums.length; i++) {

            // Skip duplicates
            if(i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            res.add(nums[i]);

            solve(i + 1, nums, res, ans);

            res.remove(res.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        solve(0, nums, new ArrayList<>(), ans);

        return ans;
    }
}
