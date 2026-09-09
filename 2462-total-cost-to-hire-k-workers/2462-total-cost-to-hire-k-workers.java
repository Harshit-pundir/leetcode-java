class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int i = 0;
        int j = n - 1;

        // Overlap hone se bachne ke liye
        while (i <= j && left.size() < candidates) {
            left.offer(costs[i++]);
        }

        while (i <= j && right.size() < candidates) {
            right.offer(costs[j--]);
        }

        long ans = 0;

        while (k > 0) {
            if (right.isEmpty() || (!left.isEmpty() && left.peek() <= right.peek())) {
                ans += left.poll();

                if (i <= j) {
                    left.offer(costs[i++]);
                }
            } else {
                ans += right.poll();

                if (i <= j) {
                    right.offer(costs[j--]);
                }
            }

            k--;
        }

        return ans;
    }
}