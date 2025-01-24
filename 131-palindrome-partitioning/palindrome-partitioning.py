class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        path = []
        def myFun(i):
            if i >= len(s):
                res.append(path[:])
                return
            for j in range(i,len(s)):
                if s[i:j + 1] == s[i:j+1][::-1]:
                    path.append(s[i:j+1])
                    myFun(j+1)
                    path.pop()
        myFun(0)
        return res
        
