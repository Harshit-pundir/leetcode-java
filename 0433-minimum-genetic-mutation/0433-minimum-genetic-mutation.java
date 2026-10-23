import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));

        if (!set.contains(endGene)) return -1;

        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<String> q = new LinkedList<>();
        q.offer(startGene);

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                String curr = q.poll();

                if (curr.equals(endGene)) return steps;

                char[] arr = curr.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for (char gene : genes) {
                        if (gene == original) continue;

                        arr[i] = gene;
                        String next = new String(arr);

                        if (set.contains(next)) {
                            q.offer(next);
                            set.remove(next);
                        }
                    }

                    arr[i] = original;
                }
            }

            steps++;
        }

        return -1;
    }
}