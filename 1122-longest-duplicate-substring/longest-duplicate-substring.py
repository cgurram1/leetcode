class Solution:
    def longestDupSubstring(self, s: str) -> str:
        duplicated = set()
        resultStr = ""
        low = 0
        high = len(s) - 1
        while low <= high:
            mid = (low + high)//2
            left = 0
            right = mid
            duplicated.clear()
            found = False
            while right < len(s):
                myStr = s[left:right+1]
                if myStr in duplicated:
                    resultStr = myStr
                    found = True
                    break
                else:
                    duplicated.add(myStr)
                left+=1
                right+=1
            if found:
                low = mid + 1
            else:
                high = mid - 1
        return resultStr
        