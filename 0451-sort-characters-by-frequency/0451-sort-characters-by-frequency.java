class Solution {
    class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String frequencySort(String s) {

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> b.freq - a.freq);

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : map.keySet()) {
            pq.add(new Pair(ch, map.get(ch)));
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            char ch = curr.ch;
            int fq = curr.freq;

            while (fq-- > 0) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}