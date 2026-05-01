class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        left = max(nums)
        right = sum(nums)
        if k == 1:
            return right
        total = right
        ans = -1

        def split(maxVal):
            currSum = 0
            count = 1
            for num in nums:
                if currSum + num <= maxVal:
                    currSum += num
                else:
                    count += 1
                    currSum = num
                    if count > k:
                        return False
            return True

        while left <= right:
            mid = (left+right)//2
            if split(mid):
                ans = mid
                right = mid - 1
            else:
                left = mid + 1
        return ans