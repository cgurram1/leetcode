class Solution:
    def maxValueOfCoins(self, piles: List[List[int]], k: int) -> int:
        def DFS(index,k):
            #Base Case
            if k == 0 or index == len(piles):
                return 0
            if (index,k) in dp:
                return dp[(index,k)]

            #Skip Pile index
            dp[(index,k)] = DFS(index + 1,k)
            #Pick from Pile index
            current_pile = 0
            for i in range(min(k,len(piles[index]))):
                current_pile += piles[index][i]
                dp[(index,k)] = max(dp[(index,k)], current_pile + DFS(index + 1,k - i - 1))
            return dp[(index,k)]
        
        dp = {}
        return DFS(0,k)
