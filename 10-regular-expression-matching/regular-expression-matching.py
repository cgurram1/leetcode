"""
p
aab


  p
c*a*b

"""

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        def fun(p1,p2):
            if p2 == len(p):
                return p1 == len(s)
            if p1 == len(s):
                while p2 + 1 < len(p) and p[p2+1] == '*':
                    p2 += 2
                return p2 == len(p)
            if p2 + 1 < len(p) and p[p2+1] == '*':
                if p[p2] == '.':
                    if fun(p1,p2+2) or fun(p1+1,p2):
                        return True
                else:
                    i = p1
                    if fun(i,p2+2):
                        return True
                    while i < len(s) and s[i] == p[p2]:
                        if fun(i+1,p2+2):
                            return True
                        i+=1
            elif s[p1] == p[p2] or p[p2] == '.':
                if fun(p1+1,p2+1):
                    return True
            return False
        return fun(0,0)
