class Solution:
    def removeOccurrences(self, s: str, part: str) -> str:
        res = ""
        for ch in s:
            if len(res) >= len(part)-1 and ch == part[-1] and res[len(res)-(len(part)-1):] == part[:len(part)-1]:
                res = res[:len(res)-(len(part)-1)]
            else:
                res+=ch
        return res
