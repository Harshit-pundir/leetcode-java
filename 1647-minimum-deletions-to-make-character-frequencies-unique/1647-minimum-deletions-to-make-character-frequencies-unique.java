class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();
        int ans = 0;

        for (int fq : map.values()) {

            while (fq > 0 && set.contains(fq)) {
                fq--;
                ans++;
            }

            if (fq > 0) {
                set.add(fq);
            }
        }

        return ans;
    }
}