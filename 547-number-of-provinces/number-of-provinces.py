class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        def find(n):
            if parent[n] == n:
                return n
            parent[n] = find(parent[n])
            return parent[n]
        def union(n1,n2):
            pn1 = find(n1)
            pn2 = find(n2)
            parent[pn1] = pn2
        result = set()
        parent = [i for i in range(len(isConnected))]
        for i in range(len(isConnected)):
            for j in range(i,len(isConnected)):
                if isConnected[i][j] == 1:
                    union(i,j)
        for i in range(len(isConnected)):
            result.add(find(i))
        return len(result)