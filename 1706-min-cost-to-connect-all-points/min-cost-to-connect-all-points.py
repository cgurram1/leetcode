class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        V = len(points)
        visited = set()
        res = 0
        pq = [(0, 0)]
        while len(visited) < V:
            weight, node = heapq.heappop(pq)
            if node in visited:
                continue
            res += weight
            visited.add(node)
            for k in range(V):
                if k not in visited:
                    nextWeight = abs(points[k][0] - points[node][0]) + abs(points[k][1] - points[node][1])
                    heapq.heappush(pq, (nextWeight, k))
        return res
        
