class Solution {
    HashMap<Integer, Integer> map;
    Random random;
    int size;

    public Solution(int n, int[] blacklist) {
        size = n - blacklist.length;
        map = new HashMap<>();
        random = new Random();

        HashSet<Integer> set = new HashSet<>();
        for (int num : blacklist) {
            set.add(num);
        }

        int last = n - 1;

        for (int num : blacklist) {
            if (num < size) {
                while (set.contains(last)) {
                    last--;
                }

                map.put(num, last);
                last--;
            }
        }
    }

    public int pick() {
        int idx = random.nextInt(size);
        return map.getOrDefault(idx, idx);
    }
}