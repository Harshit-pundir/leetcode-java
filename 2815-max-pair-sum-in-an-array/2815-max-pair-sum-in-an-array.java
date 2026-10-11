
class Solution {
    public int maxSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;

        for (int num : nums) {
            int temp = num;
            int digitMax = 0;

            while (temp != 0) {
                digitMax = Math.max(digitMax, temp % 10);
                temp /= 10;
            }

            if (map.containsKey(digitMax)) {
                ans = Math.max(ans, map.get(digitMax) + num);
            }

            map.put(digitMax,
                Math.max(map.getOrDefault(digitMax, Integer.MIN_VALUE), num));
        }

        return ans;
    }
}
