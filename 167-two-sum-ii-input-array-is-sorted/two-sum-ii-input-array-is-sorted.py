class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
      right = len(numbers) - 1
      left = 0
      while(left != right):
        curr_sum = numbers[left] + numbers[right]
        if curr_sum > target:
            right-=1
        elif curr_sum < target:
            left+=1
        else:
            return [left + 1,right+1] 