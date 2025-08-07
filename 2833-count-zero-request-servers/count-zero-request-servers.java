class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        int[][] queryWithIndex = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            queryWithIndex[i][0] = queries[i];
            queryWithIndex[i][1] = i;
        }
        Arrays.sort(queryWithIndex, (a, b) -> Integer.compare(a[0], b[0]));
        int[] result = new int[queries.length];
        int start = 0;
        int end = 0;
        Map<Integer, Integer> serverFreq = new HashMap<>();
        for (int[] query : queryWithIndex) {
            int time = query[0];
            int idx = query[1];
            while (end < logs.length && logs[end][1] <= time) {
                int serverId = logs[end][0];
                serverFreq.put(serverId, serverFreq.getOrDefault(serverId, 0) + 1);
                end++;
            }
            while (start < logs.length && logs[start][1] < time - x) {
                int serverId = logs[start][0];
                serverFreq.put(serverId, serverFreq.get(serverId) - 1);
                if (serverFreq.get(serverId) == 0) {
                    serverFreq.remove(serverId);
                }
                start++;
            }
            result[idx] = n - serverFreq.size();
        }
        return result;
    }
}
