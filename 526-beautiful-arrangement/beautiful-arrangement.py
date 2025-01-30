class Solution:
    def countArrangement(self, n: int) -> int:
        def isValid(s):
            for i in range(1,len(s)+1):
                if s[i-1] % i != 0 and i % s[i-1] != 0:
                    return False
            return True
        
        def myFun(arr):
            if isValid(arr):
                if n == len(arr):
                    count[0]+=1
                    return
            else:
                return
            for j in range(1,n+1):
                if j not in arr:
                    arr.append(j)
                    myFun(arr)
                    arr.pop(-1)
        count = [0]
        myFun([])
        return count[0]
        