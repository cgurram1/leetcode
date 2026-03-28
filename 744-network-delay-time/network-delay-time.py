class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adjList = [[] for _ in range(n+1)]
        for time in times:
            adjList[time[0]].append((time[1],time[2]))
        
        dists = [float('inf') for _ in range(n+1)]
        dists[k] = 0

        queue = [(0,k)]
        while queue:
            poppedDist,poppedServer = heapq.heappop(queue)
            for nextServer,nextTime in adjList[poppedServer]:
                if poppedDist + nextTime < dists[nextServer]:
                    dists[nextServer] = poppedDist + nextTime
                    heapq.heappush(queue,(dists[nextServer],nextServer))
        ans = max(dists[1:])
        if ans == float('inf'):
            return -1
        return ans