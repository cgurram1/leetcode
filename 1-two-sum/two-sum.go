func twoSum(nums []int, target int) []int {
    var result []int
    myMap := make(map[int]int)
    for index,num := range nums{
        value,ok := myMap[target - num]
        if(ok == true){
            result = append(result,index)
            result = append(result,value)
            return result
        }
        myMap[num] = index
    }
    return result
}