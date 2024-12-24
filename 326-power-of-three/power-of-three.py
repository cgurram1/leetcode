class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        if n == 3 or n == 1:
            return True
        elif n < 3:
            return False
        if n % 3 == 0 and Solution.isPowerOfThree(self,n//3):
            return True
        return False