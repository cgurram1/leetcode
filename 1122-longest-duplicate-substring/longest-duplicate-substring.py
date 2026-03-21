class Solution:
    def longestDupSubstring(self, s: str) -> str:
        resultStr = ""
        n = len(s)

        low = 1
        high = n - 1

        base = 29
        mod = 2**63 - 1
        powers = [1] * n
        for i in range(1, n):
            powers[i] = (powers[i - 1] * base) % mod

        while low <= high:
            mid = (low + high) // 2

            left = 0
            right = mid - 1

            found = False
            seen = set()

            hashKey = 0
            for i in range(mid):
                charEncod = ord(s[i]) - ord('a')
                hashKey = (hashKey * base + charEncod) % mod

            seen.add(hashKey)

            power = powers[mid - 1]

            while right + 1 < n:
                right += 1

                leftChar = ord(s[left]) - ord('a')
                hashKey = (hashKey - leftChar * power) % mod
                hashKey = (hashKey * base + (ord(s[right]) - ord('a'))) % mod

                left += 1

                if hashKey in seen:
                    resultStr = s[left:right + 1]
                    found = True
                    break

                seen.add(hashKey)

            if found:
                low = mid + 1
            else:
                high = mid - 1

        return resultStr