class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        adjList = defaultdict(list)
        for fr,to in tickets:
            heapq.heappush(adjList[fr],to)
        result = []
        def dfs(fr):
            while adjList[fr]:
                nxt = heapq.heappop(adjList[fr])
                dfs(nxt)
            result.append(fr)
        dfs("JFK")
        return result[::-1]


