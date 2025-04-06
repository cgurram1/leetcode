func twoSum(nums []int, target int) []int {
    myMap := make(map[int]int)
    for i, num := range nums {
        if j, found := myMap[target-num]; found {
            return []int{j, i}
        }
        myMap[num] = i
    }
    return nil
}