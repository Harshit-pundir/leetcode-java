class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1, n, k, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(int start, int n, int k, List<Integer> temp, List<List<Integer>> ans) {
        // Base case
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i =  start; i <= n; i++) {
            temp.add(i);                   // choose
            helper(i + 1, n, k, temp, ans); // explore
            temp.remove(temp.size() - 1);   // backtrack
        }
    }
}