class Solution:
    def queryString(self, s: str, n: int) -> bool:
        nums = set()
        strs = set()
        for i in range(len(s)):
            left = 0
            right = i+1
            while(right <= len(s) and len(nums) < n):
                if s[left:right] not in strs:
                    strs.add(s[left:right])
                    val = int(s[left:right],2)
                    if(0 < val <= n):
                        nums.add(val)
                right+=1
                left+=1
        # print(nums)
        return len(nums) == n