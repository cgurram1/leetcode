class Solution:
    def countPaths(self, n: int, roads: List[List[int]]) -> int:
        dists = [float('inf') for _ in range(n)]
        dists[0] = 0
        ways = [0 for _ in range(n)]
        ways[0] = 1

        adjList = [[] for _ in range(n)]
        for road in roads:
            adjList[road[0]].append((road[1],road[2]))
            adjList[road[1]].append((road[0],road[2]))

        pq = []
        heapq.heappush(pq, (0,0))
        count = 0
        while pq:
            currDist, currCity = heapq.heappop(pq)
            if currDist > dists[currCity]:
                continue
            for adjCity,price in adjList[currCity]:
                if currDist + price < dists[adjCity]:
                    dists[adjCity] = currDist + price
                    ways[adjCity] = ways[currCity]
                    heapq.heappush(pq, (dists[adjCity],adjCity))
                elif currDist + price == dists[adjCity]:
                    ways[adjCity] += ways[currCity]
        return ways[n-1] % (10**9 + 7)