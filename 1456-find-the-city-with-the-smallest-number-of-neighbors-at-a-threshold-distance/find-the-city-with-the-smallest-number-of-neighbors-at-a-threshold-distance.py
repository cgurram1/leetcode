class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        # adjMatrix = [[float('inf') if i != j else 0 for i in range(n)] for j in range(n)]
        # for edge in edges:
        #     adjMatrix[edge[0]][edge[1]] = edge[2]
        #     adjMatrix[edge[1]][edge[0]] = edge[2]
        # for i in range(n):
        #     for r in range(n):
        #         for c in range(n):
        #             if adjMatrix[r][i] != float('inf') and adjMatrix[i][c] != float('inf'):
        #                 adjMatrix[r][c] = min(adjMatrix[r][c], (adjMatrix[r][i] + adjMatrix[i][c]))
        # minCities = n
        # result = -1
        # for i in range(n):
        #     count = 0
        #     for j in range(n):
        #         if i != j and adjMatrix[i][j] <= distanceThreshold:
        #             count+=1
        #     if count <= minCities:
        #         result = i
        #         minCities = count
        # return result
        
        def dijkshtra(src):
            pq = []
            heapq.heappush(pq, (0,src))
            while pq:
                currDist, currNode = heapq.heappop(pq)
                if currDist > dists[currNode]:
                    continue
                for adjNode, weight in adjList[currNode]:
                    if currDist + weight < dists[adjNode]:
                        dists[adjNode] = currDist + weight
                        heapq.heappush(pq, (dists[adjNode], adjNode))
        
        minCount = float('inf')
        result = -1
        adjList = [[] for _ in range(n)]
        for edge in edges:
            adjList[edge[0]].append((edge[1],edge[2]))
            adjList[edge[1]].append((edge[0],edge[2]))
        
        for i in range(n):
            dists = [float('inf') for _ in range(n)]
            dists[i] = 0
            dijkshtra(i)
            count = 0
            for j in range(n):
                if dists[j] <= distanceThreshold:
                    count+=1
            if count <= minCount:
                result = i
                minCount = count
        return result

                    