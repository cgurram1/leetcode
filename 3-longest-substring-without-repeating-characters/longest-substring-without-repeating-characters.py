class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l = 0
        r = 0
        res = 0
        myDict = {}
        while(r < len(s)):
            if s[r] not in myDict or myDict[s[r]] < l:
                myDict[s[r]] = r
            else:
                l = myDict[s[r]] + 1
                myDict[s[r]] = r
            res = max(res,r - l + 1)
            r+=1
        return res