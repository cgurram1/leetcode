class Solution:
    def climbStairs(self, n: int) -> int:
        memo = {}
        def myRec(ind):
            if ind in memo:
                return memo[ind]
            if ind > n:
                return 0
            if ind == n:
                return 1
            memo[ind] = myRec(ind + 1) + myRec(ind + 2)
            return memo[ind]
        return myRec(0)