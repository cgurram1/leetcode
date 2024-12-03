class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        res = ""
        curr = 0
        prev = 0
        for i in spaces:
            for j in range(i - prev):
                res+=s[curr]
                curr+=1
            res+=' '
            prev = i
        while(curr < len(s)):
            res+=s[curr]
            curr+=1
        return res