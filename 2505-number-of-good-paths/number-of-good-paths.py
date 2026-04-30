class Solution:
    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:
        def union(p1,p2):
            pp1 = find(p1)
            pp2 = find(p2)
            parents[pp1] = pp2
        def find(p):
            if p == parents[p]:
                return p
            parents[p] = find(parents[p])
            return parents[p]
        
        adjList = [[] for _ in range(len(vals))]
        for edge in edges:
            adjList[edge[0]].append(edge[1])
            adjList[edge[1]].append(edge[0])
        parents = [i for i in range(len(vals))]
        arr = sorted([(val,i) for i,val in enumerate(vals)])
        i = 0
        result = 0
        while i < len(arr):
            currVal = arr[i][0]
            start = i
            while i < len(arr) and arr[i][0] == currVal:
                currNode = arr[i][1]
                for adjNode in adjList[currNode]:
                    if vals[adjNode] <= currVal:
                        union(adjNode,currNode)
                i+=1


            count = defaultdict(int)
            for j in range(start, i):
                node = arr[j][1]
                parent = find(node)
                count[parent] += 1
            
            
            for c in count.values():
                result += (c * (c - 1)) // 2
                
        return result + len(vals)