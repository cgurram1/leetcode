class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start_node: int, end_node: int) -> float:
        adjList = [[] for _ in range(n)]
        for i in range(len(edges)):
            adjList[edges[i][0]].append((edges[i][1],succProb[i]))
            adjList[edges[i][1]].append((edges[i][0],succProb[i]))
        dists = [0 for _ in range(n)]
        dists[start_node] = 1
        queue = deque()
        queue.append((-1,start_node))

        while queue:
            currProb,currNode = queue.popleft()
            currProb*=-1
            if currProb < dists[currNode]:
                continue
            for nextNode,nextProb in adjList[currNode]:
                if dists[nextNode] < currProb * nextProb:
                    dists[nextNode] = currProb * nextProb
                    queue.append((-dists[nextNode],nextNode))
        return dists[end_node]
