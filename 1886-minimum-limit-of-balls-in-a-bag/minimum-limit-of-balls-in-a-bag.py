"""
[2,4,8,2]
"""

class Solution:
    def minimumSize(self, nums: List[int], maxOperations: int) -> int:
        right = max(nums)
        left = 1
        res = right
        mOps = maxOperations
        while(left <= right):
            mOps = maxOperations
            mid = (left + right)//2
            flag = -1
            for num in nums:
                opsReq = 0
                if num > mid:
                    if(num % mid == 0):
                        opsReq = num//mid - 1
                    else:
                        opsReq = num//mid
                if(opsReq > mOps):
                    left = mid + 1
                    flag = 0
                    break
                else:
                    mOps -= opsReq
            if flag == -1:
                res = mid
                right = mid - 1
        return res
        
