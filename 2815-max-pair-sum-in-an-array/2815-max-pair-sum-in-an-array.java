
class Solution {
    public int maxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sMax = Integer.MIN_VALUE;
        int n = nums.length;
        Arrays.sort(nums);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int num : nums) {
            int temp = num;
            max = 0;

            while (temp != 0) {
                int digit = temp % 10;
                if (digit > max) {
                    max = digit;
                }
                temp /= 10;
            }

            sMax = Math.max(sMax, max);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = nums[i];
            int digitMax = 0;

            while (temp != 0) {
                digitMax = Math.max(digitMax, temp % 10);
                temp /= 10;
            }

            if (!map.containsKey(digitMax)) {
                map.put(digitMax, new ArrayList<>());
            }

            map.get(digitMax).add(nums[i]);
        }

        int ans = -1;

        for (int key : map.keySet()) {
            ArrayList<Integer> temp = map.get(key);
            if (temp.size() < 2) continue;

            int sum = temp.get(0) + temp.get(1);
            ans = Math.max(sum, ans);
        }

        return ans;
    }
}
