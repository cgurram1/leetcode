"""

k: 1 - 3 O(k * )

[3,1,2]

Sum = 3

k:3
3,1,2 --> 1,2,3,3 : .     .
                    .   



7,8,5,6




    .
  .
 .              .
.
              
            .
        .
        
       .


6,5

O(k*n)

"""

class Solution:
    def sortableIntegers(self, nums: list[int]) -> int:
        def check(l,r):
            count = 0
            currMin,currMax = float('inf'),float('-inf')
            for left in range(l,r-1):
                currMin,currMax = min(currMin, nums[left]), max(currMax, nums[left])
                if nums[left] > nums[left+1]:
                    if count == 1:
                        return (float('inf'),float('-inf'))
                    else:
                        count = 1
            currMin,currMax = min(currMin, nums[r-1]), max(currMax, nums[r-1])
            if count == 0 or nums[r-1] <= nums[l]:
                return (currMin,currMax)
            return (float('inf'),float('-inf'))
        result = 0
        for k in range(1,len(nums)+1):
            toAdd = 1
            prevMax = float('-inf')
            if len(nums) % k == 0:
                # print(k,"---------")
                for i in range(0,len(nums)-k+1,k):
                    currMin,currMax = check(i,i+k)
                    # print(nums[i:i+k],currMin,currMax)
                    if (currMin == float('inf') or currMax == float('inf')) or (k != len(nums) and currMin < prevMax):
                        toAdd = 0
                        # print("Break")
                        # print((currMin == float('inf') or currMax == float('inf')))
                        # print((k != len(nums) and currMin < prevMax))
                        break
                    prevMax = currMax
                if toAdd == 1:
                    # print(k,"Added")
                    result+=k    
        return result