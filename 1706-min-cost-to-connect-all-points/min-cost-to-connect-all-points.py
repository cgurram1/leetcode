class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        V = len(points)
        adj = [[] for _ in range(V)]
        for i in range(V):
            for j in range(V):
                if i != j:
                    dist = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1])
                    adj[i].append((j,dist))
        visited = [0 for _ in range(V)]
        res = 0
        pq = [(0,0,-1)]
        while(pq):
            weight,node,parent = heapq.heappop(pq)
            if visited[node] == 0:
                res+=weight
                visited[node] = 1
                for nextNode,nextWeight in adj[node]:
                    if nextNode != parent:
                        heapq.heappush(pq,(nextWeight,nextNode,node))
        return res
        
