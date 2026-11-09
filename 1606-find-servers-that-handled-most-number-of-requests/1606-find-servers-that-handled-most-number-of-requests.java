class Solution {
    class busy {
        int freeTime;
        int idx;

        busy(int freeTime, int idx) {
            this.freeTime = freeTime;
            this.idx = idx;
        }
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        TreeSet<Integer> available = new TreeSet<>();

        PriorityQueue<busy> busyServer = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.freeTime, b.freeTime);
        });

        int[] count = new int[k];

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {
            int time = arrival[i];

            while (!busyServer.isEmpty() && busyServer.peek().freeTime <= time) {
                busy curr = busyServer.poll();
                available.add(curr.idx);
            }

            if (available.isEmpty()) {
                continue;
            }

            int server = i % k;

            Integer idx = available.ceiling(server);

            if (idx == null) {
                idx = available.first();
            }

            available.remove(idx);

            count[idx]++;

            busyServer.offer(new busy(time + load[i], idx));
        }

        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}
