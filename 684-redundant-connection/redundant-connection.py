class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        parent = [i for i in range(len(edges)+1)]
        def union(c1,c2):
            p1 = find(c1)
            p2 = find(c2)
            parent[p1] = p2
        def find(c):
            if parent[c] != c:
                parent[c] = find(parent[c])
            return parent[c]

        for edge in edges:
            if find(edge[0]) != find(edge[1]):
                union(edge[0],edge[1])
            else:
                return edge