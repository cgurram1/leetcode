class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        l = 0
        r = 0
        count = 0
        myDict = {}
        while(r < len(s)):
            myDict[s[r]] = myDict.get(s[r], 0) + 1
            while len(myDict) == 3:
                count+= (len(s) - r)
                if myDict[s[l]] == 1:
                    del myDict[s[l]]
                else:
                    myDict[s[l]]-=1
                l+=1
            r+=1
        return count
