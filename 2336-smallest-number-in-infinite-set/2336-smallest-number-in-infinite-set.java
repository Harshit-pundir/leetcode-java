class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    HashSet<Integer> set;
    int curr;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        curr = 1;
    }

    public int popSmallest() {
        if (!pq.isEmpty()) {
            int num = pq.poll();
            set.remove(num);
            return num;
        }

        return curr++;
    }

    public void addBack(int num) {
        if (num < curr && !set.contains(num)) {
            pq.offer(num);
            set.add(num);
        }
    }
}