class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        def myFun(index,s,path,res):
            if index == len(s):
                res.append(path[:])
                return
            for i in range(index,len(s)):
                if s[index:i+1] == s[index:i+1][::-1]:
                    path.append(s[index:i+1])
                    myFun(i+1,s,path,res)
                    path.pop(-1)
        myFun(0,s,[],res)
        return res