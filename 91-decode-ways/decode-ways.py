class Solution:
    def numDecodings(self, s: str) -> int:
        dp = [-1 for _ in range(len(s)+1)]
        def fun(index):
            if index == len(s):
                return 1
            if dp[index] != -1:
                return dp[index]
            ans = 0
            for i in range(index+1,len(s)+1):
                if s[index] != '0' and 0 < int(s[index:i]) <= 26:
                    ans+=fun(i)
                else:
                    break
            dp[index] = ans
            return ans
        return fun(0)