class Solution:
    def numFactoredBinaryTrees(self, arr):
        MOD = 10**9 + 7

        arr.sort(reverse=True)

        m = {}
        for a in arr:
            m[a] = 1

        for i in range(len(arr) - 1, -1, -1):
            left = i + 1
            right = len(arr) - 1

            while left <= right:
                product = arr[left] * arr[right]

                if product == arr[i]:
                    if left == right:
                        m[arr[i]] += m[arr[left]] * m[arr[right]]
                    else:
                        m[arr[i]] += 2 * m[arr[left]] * m[arr[right]]

                    m[arr[i]] %= MOD

                    left += 1
                    right -= 1

                elif product < arr[i]:
                    # Need a larger product
                    right -= 1

                else:
                    # Need a smaller product
                    left += 1

        answer = 0
        for value in m.values():
            answer = (answer + value) % MOD

        return answer