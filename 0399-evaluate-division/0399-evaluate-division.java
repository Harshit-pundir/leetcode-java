class Solution {

    class Pair {
        String node;
        double value;

        Pair(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Pair>> graph = new HashMap<>();

        // Graph banana
        for (int i = 0; i < equations.size(); i++) {

            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            // a / b = values[i]
            graph.get(a).add(new Pair(b, values[i]));

            // b / a = 1 / values[i]
            graph.get(b).add(new Pair(a, 1.0 / values[i]));
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            // Variable exist nahi karti
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                ans[i] = -1.0;
                continue;
            }

            Set<String> visited = new HashSet<>();

            ans[i] = dfs(start, end, 1.0, graph, visited);
        }

        return ans;
    }

    private double dfs(
        String curr,
        String target,
        double product,
        Map<String, List<Pair>> graph,
        Set<String> visited
    ) {

        // Target mil gaya
        if (curr.equals(target)) {
            return product;
        }

        visited.add(curr);

        for (Pair p : graph.get(curr)) {

            if (!visited.contains(p.node)) {

                double result = dfs(
                    p.node,
                    target,
                    product * p.value,
                    graph,
                    visited
                );

                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }
}