class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        dp = {}
        def fun(l,r):
            if l > r:
                return 0
            if l == r:
                return 1
            if (l,r) in dp:
                return dp[(l,r)]
            if s[l] == s[r]:
                ans = 2 + fun(l+1,r-1)  
            else:
                ans = max(fun(l+1,r),fun(l, r-1))
            dp[(l,r)] = ans
            return ans
        return fun(0,len(s)-1)
        