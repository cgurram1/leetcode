class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp = [[0] * (row + 1) for row in range(len(triangle) + 1)]
        for row in range(len(triangle)-1,-1,-1):
            for j in range(len(triangle[row])):
                dp[row][j] = triangle[row][j] + min(dp[row+1][j], dp[row+1][j+1])
        return dp[0][0]

        # def fun(row, index):
        #     if row == len(triangle):
        #         return 0
        #     return triangle[row][index] + min(fun(row+1,index), fun(row+1,index+1))

        # return fun(0,0)