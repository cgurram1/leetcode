class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        res = []
        def isValid(s):
            if len(s) > 0:
                if len(s) > 1 and int(s) == 0:
                    return False
                if (int(s) > 0 and s[0] == "0") or int(s) > 255:
                    return False
                return True
            return False
        def myFun(s,index,count,path):
            if count == 0:
                if isValid(s[index:]):
                    res.append(path + s[index:])
                return
            for i in range(index,index+3):
                if i < len(s) and isValid(s[index:i+1]):
                    myFun(s,i+1,count-1,path + s[index:i+1] + ".")
        myFun(s,0,3,"")
        return res
        
        