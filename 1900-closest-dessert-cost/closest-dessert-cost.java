class Solution {
    private int res=Integer.MIN_VALUE, diff=Integer.MAX_VALUE;
    int target;
    int[] toppingCosts;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.toppingCosts=toppingCosts;
        this.target=target;
        for(int i=0;i<baseCosts.length;i++){
            closestCostImpl(0, baseCosts[i]);
        }
        return res;
    }
    private void closestCostImpl(int ind, int temp_sum){
        int curDiff = Math.abs(temp_sum - target);

        if (curDiff < diff) {
            diff = curDiff;
            res = temp_sum;
        } else if (curDiff == diff) {
            res = Math.min(res, temp_sum); // Prefer smaller cost in tie
        }
        if(ind>=toppingCosts.length) return;

        for(int i=0;i<3;i++){
            closestCostImpl(ind+1, temp_sum + i*toppingCosts[ind]);
        }
    }
}









// class Solution {
//     public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
//         Set<Integer> possibleToppings = new HashSet<>();
//         fun(0,new ArrayList<>(),toppingCosts,0,possibleToppings);
//         int result = Integer.MAX_VALUE;
//         int answer = 0;
//         for(int i = 0;i<baseCosts.length;i++){
//             for(int possibleCost : possibleToppings){
//                 if(target - (baseCosts[i] + possibleCost) < result && target - (baseCosts[i] + possibleCost) >= 0){
//                     result = target - (baseCosts[i] + possibleCost);
//                     answer = baseCosts[i] + possibleCost;
//                 }
//             }
//         }
//         return answer;
//     }
//     public void fun(int index, List<Integer> curr, int[] toppingCosts, int cost,Set<Integer> possibleToppings){
//         if(index == toppingCosts.length){
//             possibleToppings.add(cost);
//             return;
//         }
//         if(curr.size() > 1){
//             if(toppingCosts[index] == curr.get(curr.size()-1) && toppingCosts[index] == curr.get(curr.size()-2)){
//             }
//             else{
//                 curr.add(toppingCosts[index]);
//                 fun(index, curr,toppingCosts,cost + toppingCosts[index], possibleToppings);
//                 curr.remove(curr.size()-1);
//             }
//         }
//         else{
//             curr.add(toppingCosts[index]);
//             fun(index, curr,toppingCosts,cost + toppingCosts[index], possibleToppings);
//             curr.remove(curr.size()-1);
//         }
//         fun(index + 1, curr,toppingCosts,cost,possibleToppings);
//     }
// }