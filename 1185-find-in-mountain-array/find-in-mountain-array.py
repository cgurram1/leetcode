from typing import List

class Solution:
    def findInMountainArray(self, target: int, mountainArr: 'MountainArray') -> int:
        left = 0
        right = mountainArr.length() - 1
        peak = -1
        while left < right:
            mid = (left + right) // 2
            if mountainArr.get(mid) < mountainArr.get(mid + 1):
                left = mid + 1
            else:
                right = mid
        peak = left
        def find(left, right, flag):
            while left <= right:
                mid = (left + right) // 2
                mi = mountainArr.get(mid)

                if mi == target:
                    return mid
                elif mi < target:
                    if flag == 0:
                        left = mid + 1
                    else:
                        right = mid - 1
                else:
                    if flag == 0:
                        right = mid - 1
                    else:
                        left = mid + 1
            return -1
        res = find(0, peak, 0)
        if res != -1:
            return res
        return find(peak + 1, mountainArr.length() - 1, 1)