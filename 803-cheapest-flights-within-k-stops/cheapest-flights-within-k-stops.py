class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        queue = [(0,src,0)]
        dist = [float('inf') for _ in range(n)]
        dist[src] = 0
        adj = [[] for _ in range(n)]
        for arr in flights:
            adj[arr[0]].append((arr[1],arr[2]))
        while(queue):
            stops,curr,price = heapq.heappop(queue)
            stops = stops + 1
            for nextNode,nextPrice in adj[curr]:
                if price + nextPrice < dist[nextNode] and stops <= k + 1:
                    dist[nextNode] = price + nextPrice
                    heapq.heappush(queue,(stops,nextNode,price + nextPrice))
        if dist[dst] == float('inf'):
            return -1
        return dist[dst]
                
                    


