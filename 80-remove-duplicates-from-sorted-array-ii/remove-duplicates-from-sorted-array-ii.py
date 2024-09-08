class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        left = 0
        right = 0
        count = 1
        res = 1
        skip = 0
        while(left < len(nums) -1 ):
            if count < 2 and nums[left+1] == nums[left]:
                left+=1
                right+=1
                count+=1
                res+=1
            elif count <= 2 and nums[left+1] != nums[left]:
                count = 1
                left+=1
                right+=1
                res+=1
            else:
                right+=1
                while(right < len(nums) and nums[right] == nums[left]):
                    skip +=1
                    right+=1
                left +=1
                nums[left: ] = nums[right : ]
                
                right = left
                count = 1
        return res + skip
