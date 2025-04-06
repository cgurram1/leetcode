func containsDuplicate(nums []int) bool {
    myMap := make(map[int]bool)
    for _, val := range nums {
        if myMap[val] {
            return true
        }
        myMap[val] = true
    }
    return false
}
