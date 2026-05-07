class Solution:
    def sumOfDistancesInTree(self, n: int, edges: List[List[int]]) -> List[int]:
        adjList = [[] for _ in range(n)]
        for edge in edges:
            adjList[edge[0]].append(edge[1])
            adjList[edge[1]].append(edge[0])
        data = [None for _ in range(n)]
        def dfs(node,parent):
            # if not node:
            #     return [0,0]
            ans = [0,0]
            for nextNode in adjList[node]:
                if nextNode != parent:
                    curr = dfs(nextNode,node)
                    ans[0]+=curr[0]
                    ans[1]+= (curr[0] + curr[1])
            ans[0]+=1
            data[node] = ans
            return ans
        dfs(0,-1)
        # print(data)
        result = [0 for _ in range(n)]
        def dists(node,parent):
            if parent == -1:
                result[node] = data[node][1]
            for nextNode in adjList[node]:
                if nextNode != parent:
                    result[nextNode] = (result[node] - data[nextNode][0] + (n - data[nextNode][0]))
                    dists(nextNode,node)
        dists(0,-1)
        return result 



        