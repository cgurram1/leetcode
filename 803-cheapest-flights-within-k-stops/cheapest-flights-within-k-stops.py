class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        dists = [float('inf') for _ in range(n)]
        queue = deque()
        adjList = [[] for _ in range(n)]
        for flight in flights:
            adjList[flight[0]].append((flight[1],flight[2]))

        queue.append((0,src,0))

        while queue:
            currStops,currCity,currPrice = queue.popleft()
            for adjCity,nextPrice in adjList[currCity]:
                if currStops <= k and dists[adjCity] > currPrice + nextPrice:
                    dists[adjCity] = currPrice + nextPrice
                    queue.append((currStops + 1, adjCity, dists[adjCity]))
        if dists[dst] == float('inf'):
            return -1
        return dists[dst]
