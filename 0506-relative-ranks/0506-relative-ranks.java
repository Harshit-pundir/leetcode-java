class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : score) {
            pq.add(num);
        }

        int rank = 1;

        while (!pq.isEmpty()) {
            map.put(pq.poll(), rank);
            rank++;
        }

        String[] ans = new String[score.length];

        for (int i = 0; i < score.length; i++) {
            int num = score[i];
            int r = map.get(num);

            if (r == 1) ans[i] = "Gold Medal";
            else if (r == 2) ans[i] = "Silver Medal";
            else if (r == 3) ans[i] = "Bronze Medal";
            else ans[i] = String.valueOf(r);
        }

        return ans;
    }
}