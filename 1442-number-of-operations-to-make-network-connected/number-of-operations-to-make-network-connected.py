class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        parents = [i for i in range(n)]
        rank = [0 for _ in range(n)]
        def findPar(x):
            if parents[x] != x:
                parents[x] = findPar(parents[x])
            return parents[x]
        def union(u,v):
            par_u = findPar(u)
            par_v = findPar(v)
            if par_u == par_v:
                return True
            if rank[par_u] == rank[par_v]:
                parents[par_u] = parents[par_v]
                rank[par_v]+=1
            elif rank[par_u] < rank[par_v]:
                parents[par_u] = parents[par_v]
            else:
                parents[par_v] = parents[par_u]
            return False
        
        extraEdges = 0
        for connection in connections:
            if union(connection[0],connection[1]):
                extraEdges+=1
        for i in range(n):
            findPar(i)
        comps = len(set(parents))
        if extraEdges + 1 >= comps:
            return comps - 1
        return -1

