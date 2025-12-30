class Solution {
    long fuel = 0;
    int seats;

    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= roads.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            adjList.get(roads[i][0]).add(roads[i][1]);
            adjList.get(roads[i][1]).add(roads[i][0]);
        }

        this.seats = seats;
        dfs(0, adjList, -1);

        return fuel;
    }

    public int dfs(int city, List<List<Integer>> adjList, int parent) {
        int currSum = 0;

        for (int nextCity : adjList.get(city)) {
            if (nextCity != parent) {
                currSum += dfs(nextCity, adjList, city);
            }
        }

        int people = 1 + currSum;
        
        if (city != 0) {
            fuel += (people + seats - 1) / seats;
        }

        return people;
    }
}
