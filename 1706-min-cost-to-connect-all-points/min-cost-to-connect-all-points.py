class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        rank = [0 for _ in range(len(points))]
        parent = [i for i in range(len(points))]
        def findPar(x):
            if parent[x] != x:
                parent[x] = findPar(parent[x])
            return parent[x]
        def union(u,v):
            par_u = findPar(u)
            par_v = findPar(v)
            if par_u == par_v:
                return False
            else:
                if rank[par_u] == rank[par_v]:
                    parent[par_u] = parent[par_v]
                    rank[par_v]+=1
                elif rank[par_u] < rank[par_v]:
                    parent[par_u] = par_v
                else:
                    parent[par_v] = par_u
                return True
        edges = []
        for i in range(len(points)):
            for j in range(i+1,len(points)):
                diff = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1])
                edges.append([diff,i,j])
        edges = sorted(edges)
        mst_cost = 0
        edges_used = 0
        for weight, u, v in edges:
            if union(u, v):
                mst_cost += weight
                edges_used += 1
                if edges_used == len(points) - 1:
                    break
        return mst_cost






















        # Prims algorithm
        # V = len(points)
        # visited = set()
        # res = 0
        # pq = [(0, 0)]
        # while len(visited) < V:
        #     weight, node = heapq.heappop(pq)
        #     if node in visited:
        #         continue
        #     res += weight
        #     visited.add(node)
        #     for k in range(V):
        #         if k not in visited:
        #             nextWeight = abs(points[k][0] - points[node][0]) + abs(points[k][1] - points[node][1])
        #             heapq.heappush(pq, (nextWeight, k))
        # return res
        
