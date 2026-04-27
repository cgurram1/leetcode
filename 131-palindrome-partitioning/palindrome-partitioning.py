class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def isPalindrome(left,right):
            while left <= right:
                if s[left] != s[right]:
                    return False
                left+=1
                right-=1
            return True
        def fun(i,arr):
            if i == len(s):
                result.append(arr.copy())
                return
            for ctr in range(i+1,len(s)+1):
                if isPalindrome(i,ctr-1):
                    arr.append(s[i:ctr])
                    fun(ctr,arr)
                    arr.pop(-1)
        result = []
        fun(0,[])
        return result
