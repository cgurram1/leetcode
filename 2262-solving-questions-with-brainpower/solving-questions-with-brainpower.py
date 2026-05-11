class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        dp = [-1 for _ in range(len(questions))]
        def fun(i):
            if i >= len(questions):
                return 0
            if dp[i] != -1:
                return dp[i]
            dp[i] = max(questions[i][0] + fun(i + questions[i][1]+1), fun(i+1))
            return dp[i]
        return fun(0)