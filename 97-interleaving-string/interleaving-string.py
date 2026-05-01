class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        if len(s1) + len(s2) != len(s3):
            return False
        dp = {}
        def fun(i1,i2):
            i = i1 + i2
            if (i1,i2) in dp:
                return dp[(i1,i2)]
            if i == len(s3):
                return True
            if i1 < len(s1) and s1[i1] == s3[i]:
                if fun(i1+1,i2):
                    dp[(i1+1,i2)] = True
                    return True
            if i2 < len(s2) and s2[i2] == s3[i]:
                if fun(i1,i2+1):
                    dp[(i1,i2+1)] = True
                    return True
            dp[(i1,i2)] = False
            return False
        return fun(0,0)
