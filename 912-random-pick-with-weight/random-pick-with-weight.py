class Solution:
    def __init__(self, w: List[int]):
        self.prefix = []
        total = 0

        for weight in w:
            total += weight
            self.prefix.append(total)

        self.total = total

    def pickIndex(self) -> int:
        target = random.randint(1, self.total)

        left, right = 0, len(self.prefix) - 1

        while left < right:
            mid = (left + right) // 2
            if self.prefix[mid] < target:
                left = mid + 1
            else:
                right = mid

        return left