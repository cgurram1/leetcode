class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        # base = 31
        # mod = 10**9 + 7
        # targetHash = 0
        # for ch in t:
        #     targetHash = (targetHash * base + (ord(ch) - ord('a') + 1)) % mod
        # dp = {}
        # def fun(index,hashVal):
        #     if hashVal == targetHash:
        #         return 1
        #     if index == len(s):
        #         return 0
        #     if (index,hashVal) in dp:
        #         return dp[(index,hashVal)]
        #     ans = fun(index+1,(hashVal * base + (ord(s[index]) - ord('a') + 1)) % mod) + fun(index+1,hashVal)
        #     dp[(index,hashVal)] = ans
        #     return ans
        # return fun(0,0)

        dp = [[0] * (len(t)+1) for _ in range(len(s)+1)]
        for i in range(len(s)+1):
            dp[i][len(t)] = 1
        for i2 in range(len(t)-1,-1,-1):
            for i1 in range(len(s)-1,-1,-1):
                if s[i1] == t[i2]:
                    dp[i1][i2]+=(dp[i1+1][i2+1] + dp[i1+1][i2])
                else:
                    dp[i1][i2] = dp[i1+1][i2]
        return dp[0][0]
        # def fun(i1,i2):
        #     if i2 == len(t):
        #         return 1
        #     if dp[i1][i2] != -1:
        #         return dp[i1][i2]
        #     ans = 0
        #     for i in range(i1,len(s)):
        #         if s[i] == t[i2]:
        #             ans+=fun(i+1,i2+1)
        #     dp[i1][i2] = ans
        #     return ans
        # return fun(0,0)
