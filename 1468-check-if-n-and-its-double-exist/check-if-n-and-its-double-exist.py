class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        s = set()
        for i in arr:
            if i % 2 == 0:
                if i * 2 in s or i // 2 in s:
                    return True
            else:
                if i * 2 in s:
                    return True
            s.add(i)
        return False