class Solution:
    def closestCost(self, baseCosts, toppingCosts, target):
        best = float('inf')

        def dfs(i, curr):
            nonlocal best
            if abs(curr - target) < abs(best - target) or \
               (abs(curr - target) == abs(best - target) and curr < best):
                best = curr

            if i == len(toppingCosts) or curr > target + abs(best - target):
                return

            # 0 topping
            dfs(i + 1, curr)

            # 1 topping
            dfs(i + 1, curr + toppingCosts[i])

            # 2 toppings
            dfs(i + 1, curr + 2 * toppingCosts[i])

        for base in baseCosts:
            dfs(0, base)

        return best
