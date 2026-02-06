class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        @lru_cache(None)
        def recFun(r,c):
            if(r == len(grid)-1):
                return grid[r][c]
            currSum = float('inf')
            for nextc in range(len(grid[0])):
                if nextc != c:
                    currSum = min(currSum , recFun(r+1, nextc))
            return currSum + grid[r][c]
        minRes = float('inf')
        for i in range(len(grid[0])):
            minRes = min(minRes, recFun(0,i))
        return minRes
            