class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def isPalindrome(left,right):
            while left < right:
                if s[left] != s[right]:
                    return False
                left+=1
                right-=1
            return True
        
        def REC(index,arr):
            # print(arr)
            if index == len(s):
                result.append(arr.copy())
                return
            for i in range(index,len(s)):
                if isPalindrome(index, i):
                    arr.append(s[index:i+1])
                    REC(i + 1,arr)
                    arr.pop()
        result = []
        REC(0,[])
        return result