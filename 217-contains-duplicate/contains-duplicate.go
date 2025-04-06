func containsDuplicate(nums []int) bool {
    var myMap map[int]bool = make(map[int]bool)
    for _,val := range nums {
        _, ok := myMap[val]
        if ok == false{
            myMap[val] = true
        } else {
            return true
        }
    }
    return false
}