class Solution:
    def calculateScore(self, s: str) -> int:
        resDict = {}
        res = 0
        for i in range(len(s)):
            mirror = chr(122 - (ord(s[i]) - 97))
            if mirror in resDict and resDict[mirror]:
                res += (i - resDict[mirror].pop())
            else:
                if s[i] not in resDict:
                    resDict[s[i]] = []
                resDict[s[i]].append(i)
        return res
        



