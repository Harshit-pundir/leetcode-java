class Solution {
    public int countSuffix(int[] nums, int[] target) {
        int n = nums.length;

        int firstMismatch = n;

        for (int i = 0; i < n; i++) {
            if (nums[i] != target[i]) {
                firstMismatch = i;
                break;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        boolean sorted = true;

        for (int i = n - 1; i >= 0; i--) {

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            map.put(target[i], map.getOrDefault(target[i], 0) - 1);

            if (map.get(nums[i]) == 0) {
                map.remove(nums[i]);
            }

            if (map.containsKey(target[i]) && map.get(target[i]) == 0) {
                map.remove(target[i]);
            }

            if (i < n - 1 && target[i] < target[i + 1]) {
                sorted = false;
            }

            if (i <= firstMismatch && sorted && map.isEmpty()) {
                count++;
            }
        }

        return count;
    }
}