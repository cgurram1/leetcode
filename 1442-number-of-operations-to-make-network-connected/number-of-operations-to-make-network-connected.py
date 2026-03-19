class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        if len(connections) < n-1:
            return -1
        def find(n):
            if parent[n] == n:
                return n
            parent[n] = find(parent[n])
            return parent[n]



        def union(n1,n2):
            pn1 = find(n1)
            pn2 = find(n2)
            if rank[pn1] == rank[pn2]:
                parent[pn1] = pn2
                rank[pn2]+=1
            elif rank[pn2] > rank[pn1]:
                parent[pn1] = pn2
            else:
                parent[pn2] = pn1


        parent = [i for i in range(n)]
        rank = [0 for _ in range(n)]

        for connection in connections:
            union(connection[0],connection[1])


        result = set()
        for i in range(n):
            result.add(find(i))
        return len(result) - 1

        
