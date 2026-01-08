"""
 l 
[2,1,-2,5]

 r
[3,0,-6]

"""

class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        @lru_cache(None)
        def rec(left,right):
            if(left == len(nums1) or right == len(nums2)):
                return float('-inf')
            both = nums1[left] * nums2[right] + max(0,rec(left + 1, right + 1))
            top = rec(left+1,right)
            bottom = rec(left,right + 1)
            # none = rec(left +1,right + 1)
            return max(both, top, bottom)
        return rec(0,0)