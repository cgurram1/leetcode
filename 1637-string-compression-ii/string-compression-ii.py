"""

aaabaaad

                    f(0,2,"",0)
                f(1, 1, "", 0)          f(1,2,"a",1)
            f(2,0,"",0) f(2,1,a,1)  f()      

"""
class Solution:
    def getLengthOfOptimalCompression(self, s: str, k: int) -> int:
        @lru_cache(None)
        def recFun(i, k , ch, count):
            if(i == len(s)):
                if(ch == ""):
                    return 0
                if(count == 1):
                    return 1
                else:
                    return 1 + len(str(count))
            
            # delete this char
            ifDel = float('inf')
            if(k > 0):
                ifDel = recFun(i+1, k-1, ch, count)
            ifNoDel = float('inf')
            # do not delete this char
            if(ch != ""):
                if(ch == s[i]):
                    ifNoDel = recFun(i+1,k,ch, count+1)
                else:
                    if(count == 1):
                        ifNoDel = 1 + recFun(i+1,k,s[i],1)
                    else:
                        ifNoDel = 1 + len(str(count)) + recFun(i+1,k,s[i],1)
            else:
                ifNoDel = recFun(i+1, k, s[i], 1)

            return min(ifDel, ifNoDel)

        return recFun(0,k,"",0)
            