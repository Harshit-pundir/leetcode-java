class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int x : nums) {

            int a = map.getOrDefault(x + 1, 0) + 1;
            int b = map.getOrDefault(x, 0) + 1;

            map.put(x + 2, Math.max(map.getOrDefault(x + 2, 0), a));
            map.put(x + 1, Math.max(map.getOrDefault(x + 1, 0), b));

            ans = Math.max(ans, Math.max(a, b));
        }

        return ans;
    }
}