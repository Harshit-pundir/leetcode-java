
class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long operations = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        int right = n - 1;

        for (int left = n - 1; left >= 0; left--) {

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[left]) {
                int idx = dq.pollLast();
                int next = dq.isEmpty() ? right + 1 : dq.peekLast();

                operations += (long) (nums[left] - nums[idx]) * (next - idx);
            }

            dq.offerLast(left);

            while (operations > k) {
                int idx = dq.peekFirst();

                operations -= nums[idx] - nums[right];

                if (idx == right) {
                    dq.pollFirst();
                }

                right--;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}
