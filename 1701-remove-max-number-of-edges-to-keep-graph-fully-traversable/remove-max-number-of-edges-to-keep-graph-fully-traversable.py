class Solution:
    def maxNumEdgesToRemove(self, n: int, edges: List[List[int]]) -> int:
        parents1 = [i for i in range(n+1)]
        parents2 = [i for i in range(n+1)]
        def union(n1,n2,t):
            pp1 = find(n1,t)
            pp2 = find(n2,t)
            if t == 1:
                parents1[pp1] = pp2
            else:
                parents2[pp1] = pp2
        def find(n,t):
            if t == 1:
                if n != parents1[n]:
                    parents1[n] = find(parents1[n],t)
                return parents1[n]
            else:
                if n != parents2[n]:
                    parents2[n] = find(parents2[n],t)
                return parents2[n]
        edges.sort(reverse=True)
        count = 0
        for edge in edges:
            if edge[0] == 3 and find(edge[1],1) != find(edge[2],1):
                union(edge[1],edge[2],1)
                union(edge[1],edge[2],2)
                count+=1
            elif find(edge[1],edge[0]) != find(edge[2],edge[0]):
                union(edge[1],edge[2],edge[0])
                count+=1
        s1 = set(find(i,1) for i in range(n+1))
        s2 = set(find(i,2) for i in range(n+1))
        if len(s1) > 2 or len(s2) > 2:
            return -1
        return len(edges) - count
