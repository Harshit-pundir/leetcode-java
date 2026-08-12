import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Store positions
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int ans = Integer.MAX_VALUE;

        // Check every group
        for (ArrayList<Integer> list : map.values()) {

            for (int i = 2; i < list.size(); i++) {

                int a = list.get(i - 2);
                int b = list.get(i - 1);
                int c = list.get(i);

                int distance = Math.abs(a - b)
                             + Math.abs(b - c)
                             + Math.abs(c - a);

                ans = Math.min(ans, distance);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}