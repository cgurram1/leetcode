class Solution {
    List<List<double[]>> adjList = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    List<String> reverse = new ArrayList<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int index = 0;
        for (List<String> eq : equations) {
            for (String var : eq) {
                if (!map.containsKey(var)) {
                    map.put(var, index++);
                    reverse.add(var);
                    adjList.add(new ArrayList<>());
                }
            }
        }
        for (int i = 0; i < equations.size(); i++) {
            int u = map.get(equations.get(i).get(0));
            int v = map.get(equations.get(i).get(1));
            double val = values[i];
            adjList.get(u).add(new double[]{v, val});
            adjList.get(v).add(new double[]{u, 1.0 / val});
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            if (!map.containsKey(src) || !map.containsKey(dst)) {
                result[i] = -1.0;
            } else {
                boolean[] visited = new boolean[map.size()];
                result[i] = dfs(map.get(src), map.get(dst), visited, 1.0);
            }
        }

        return result;
    }

    private double dfs(int srcIdx, int dstIdx, boolean[] visited, double product) {
        if (srcIdx == dstIdx) return product;
        visited[srcIdx] = true;

        for (double[] neighbor : adjList.get(srcIdx)) {
            int next = (int) neighbor[0];
            double weight = neighbor[1];
            if (!visited[next]) {
                double res = dfs(next, dstIdx, visited, product * weight);
                if (res != -1.0) return res;
            }
        }

        return -1.0;
    }
}