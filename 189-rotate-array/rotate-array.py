class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if k > len(nums):
            k = k % len(nums)
        if k == 0:
            return
        toAdd = nums[- k:]
        toAdd.extend(nums[:len(nums) - k])
        nums[:] = toAdd
        