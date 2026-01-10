class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        adjList = defaultdict(list)
        for i in range(len(manager)):
            adjList[manager[i]].append(i)
        
        def rec(curr):
            time = informTime[curr]
            minT = 0
            for nextE in adjList[curr]:
                minT = max(minT, rec(nextE))
            return time + minT
        return rec(headID)