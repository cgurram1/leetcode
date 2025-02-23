class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        myDict = {}
        l = 0
        r = 0
        max_freq = 0
        currSum = 0
        res = 0
        while(r < len(s)):
            if s[r] in myDict:
                myDict[s[r]]+=1
            else:
                myDict[s[r]] = 1
            max_freq = max(myDict.values())
            if r - l + 1 - max_freq > k:
                if myDict[s[l]] == 1:
                    del myDict[s[l]]
                else:
                    myDict[s[l]]-=1
                max_freq = max(myDict.values())
                l+=1
            if r - l + 1 - max_freq <= k:
                res = max(res,r - l + 1)
            r+=1
        return res
