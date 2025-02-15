class Solution:
    def countPaths(self, n: int, roads: List[List[int]]) -> int:
        count = [1 for _ in range(n)]
        dist = [float('inf') for _ in range(n)]
        dist[0] = 0
        pq = [(0,0)]
        adj = [[] for _ in range(n)]
        for arr in roads:
            adj[arr[0]].append((arr[1],arr[2]))
            adj[arr[1]].append((arr[0],arr[2]))
        while(pq):
            currDist,currNode = heapq.heappop(pq)
            if currDist > dist[currNode]:
                continue
            for nextNode,d in adj[currNode]:
                nextDist = currDist + d
                if nextDist < dist[nextNode]:
                    dist[nextNode] = nextDist
                    count[nextNode] = count[currNode]
                    heapq.heappush(pq,(nextDist,nextNode))
                elif nextDist == dist[nextNode]:
                    count[nextNode] += count[currNode]
        return count[-1] % (10 ** 9 + 7)
        
