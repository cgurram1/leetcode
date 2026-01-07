class Solution:
    def minimumBeautifulSubstrings(self, s: str) -> int:
        @lru_cache(None)
        def rec(start,s):
            if start == len(s):
                return 0
            curr = start
            res = float('inf')
            while(curr < len(s)):
                # print(isValid(start,curr))
                if(isValid(start,curr)):
                    res = min(res, 1 + rec(curr + 1,s))
                curr+=1
            return res
        
        def isValid(start,end):
            # print(s[start:end+1])
            if(s[start] == '0'):
                return False
            num = int(s[start:end+1],2)
            while(num % 5 == 0):
                num = num // 5
            return num == 1
        
        res = rec(0,s)
        if(res == float('inf')):
            return -1
        return res
