class Solution {
    public long[] getDistances(int[] nums) {
        HashMap<Integer, Long> count = new HashMap<>();
        HashMap<Integer, Long> sum = new HashMap<>();

        long[] ans = new long[nums.length];

        // Left side contribution
        for (int i = 0; i < nums.length; i++) {

            int x = nums[i];

            long c = count.getOrDefault(x, 0L);
            long s = sum.getOrDefault(x, 0L);

            ans[i] += c * i - s;

            count.put(x, c + 1);
            sum.put(x, s + i);
        }

        count.clear();
        sum.clear();

        // Right side contribution
        for (int i = nums.length - 1; i >= 0; i--) {

            int x = nums[i];

            long c = count.getOrDefault(x, 0L);
            long s = sum.getOrDefault(x, 0L);

            ans[i] += s - c * i;

            count.put(x, c + 1);
            sum.put(x, s + i);
        }

        return ans;
    }
}