class Solution:
    def fourSum(self, nums, target):
        result = []

        def REC(start, target, k, way):
            if k == 2:
                left = start
                right = len(nums) - 1

                while left < right:
                    s = nums[left] + nums[right]

                    if s > target:
                        right -= 1
                    elif s < target:
                        left += 1
                    else:
                        way.append(nums[left])
                        way.append(nums[right])
                        result.append(way.copy())
                        way.pop()
                        way.pop()

                        left += 1
                        right -= 1

                        while left < right and nums[left] == nums[left - 1]:
                            left += 1
                        while left < right and nums[right] == nums[right + 1]:
                            right -= 1
                return

            for i in range(start, len(nums) - k + 1):
                if i == start or nums[i] != nums[i - 1]:
                    way.append(nums[i])
                    REC(i + 1, target - nums[i], k - 1, way)
                    way.pop()

        nums.sort()
        REC(0, target, 4, [])
        return result