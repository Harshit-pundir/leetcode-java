class Solution {

    class available {
        int idx;
        int weight;

        available(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    class busy {
        int freeTime;
        int idx;
        int weight;

        busy(int freeTime, int idx, int weight) {
            this.freeTime = freeTime;
            this.idx = idx;
            this.weight = weight;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        PriorityQueue<available> availableServer = new PriorityQueue<>((a, b) -> {
                if(a.weight != b.weight)
                    return a.weight - b.weight;
                return a.idx - b.idx;
        });

        PriorityQueue<busy> busyServer = new PriorityQueue<>((a, b) -> {
                if(a.freeTime != b.freeTime)
                    return a.freeTime - b.freeTime;
                if(a.weight != b.weight)
                    return a.weight - b.weight;
                return a.idx - b.idx;
        });

        for(int i = 0; i < n; i++){
            availableServer.offer(new available(i, servers[i]));
        }

        int[] ans = new int[m];
        int time = 0;
        for(int i = 0; i < m; i++){
            time = Math.max(i, time);
            while(!busyServer.isEmpty() && busyServer.peek().freeTime <= time){
                busy curr = busyServer.poll();
                availableServer.offer(new available(curr.idx, curr.weight));
            }

            if(availableServer.isEmpty()){
                time = busyServer.peek().freeTime;
                while(!busyServer.isEmpty() && busyServer.peek().freeTime <= time){
                    busy curr = busyServer.poll();
                    availableServer.offer(new available(curr.idx, curr.weight));
                }
            }

            available curr = availableServer.poll();
            ans[i] = curr.idx;
            busyServer.offer(new busy(time + tasks[i], curr.idx, curr.weight));
        }
        return ans;
    }
}