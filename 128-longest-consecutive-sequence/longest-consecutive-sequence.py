class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        set_nums = set(nums)
        visited_set = set()
        count = 0
        for i in set_nums:
            if i not in visited_set:
                curr_count = 1
                prev = i - 1
                Next = i + 1
                while(prev in set_nums):
                    curr_count+=1
                    visited_set.add(prev)
                    prev-=1
                while(Next in set_nums):
                    curr_count+=1
                    visited_set.add(Next)
                    Next+=1
                count = max(count,curr_count)
        return count
                