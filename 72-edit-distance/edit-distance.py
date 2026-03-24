"""
horse
ros
                    (horse,ros)(0,0)
            (rhorse,ros)(0,1)       orse,ros(1,0)       rorse,ros (1,1)


"""
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        def REC(i1, i2):
            if i1 == len(word1):
                return len(word2) - i2
            if i2 == len(word2):
                return len(word1) - i1
            if (i1,i2) in dp:
                return dp[(i1,i2)]
            ops = 0
            if word1[i1] != word2[i2]:
                ops = 1 + min(REC(i1,i2+1),min(REC(i1+1,i2),REC(i1+1,i2+1)))
            else:
                ops = REC(i1+1,i2+1)
            dp[(i1,i2)] = ops
            return ops
        dp = {}
        return REC(0,0)
