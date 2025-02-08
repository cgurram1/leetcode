import "sort"
import "fmt"
func twoSum(nums []int, target int) []int {
    hash := make(map[int][]int)
    for i, v := range nums {
        if _, ok := hash[v]; !ok {
            hash[v] = []int{i}
        } else {
            hash[v] = append(hash[v], i)
        }
    }
    sortedNums := make([]int, len(nums))
    copy(sortedNums, nums)
    sort.Ints(sortedNums)
    left := 0
    right := len(sortedNums) - 1
    for left < right {
        s := sortedNums[left] + sortedNums[right]
        if s == target {
            if sortedNums[left] == sortedNums[right] {
                return hash[sortedNums[left]]
            } else {
                return []int{hash[sortedNums[left]][0], hash[sortedNums[right]][0]}
            }
        } else if s < target {
            left++
        } else {
            right--
        }
    }
    return []int{}
}