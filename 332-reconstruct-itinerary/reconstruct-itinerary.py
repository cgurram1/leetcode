class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        queue = []
        adjDict = {}
        for ticket in tickets:
            if ticket[0] not in adjDict:
                adjDict[ticket[0]] = [ticket[1]]
            else:
                heapq.heappush(adjDict[ticket[0]],ticket[1])
        result = []
        def fun(start):
            while start in adjDict and adjDict[start]:
                fun(heapq.heappop(adjDict[start]))
            result.append(start)
        fun("JFK")
        return result[::-1]