
class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        Set<Integer> possibleToppings = new HashSet<>();
        fun(0,toppingCosts,0,possibleToppings);
        int res = Integer.MAX_VALUE;
        int diff = 0;
        int answer = 0;
        for(int i = 0;i<baseCosts.length;i++){
            for(int possibleCost : possibleToppings){
                int dessertCost = possibleCost + baseCosts[i];
                diff = Math.abs(target - dessertCost);
                if(diff < res){
                    answer = dessertCost;
                    res = diff;
                }
                else if(diff == res){
                    answer = Math.min(answer,dessertCost);
                }
            }
        }
        return answer;
    }
    public void fun(int index, int[] toppingCosts, int cost, Set<Integer> possibleToppings) {
        if (index == toppingCosts.length) {
            possibleToppings.add(cost);
            return;
        }
        fun(index + 1, toppingCosts, cost, possibleToppings);
        fun(index + 1, toppingCosts, cost + toppingCosts[index], possibleToppings);
        fun(index + 1, toppingCosts, cost + 2 * toppingCosts[index], possibleToppings);
    }
}