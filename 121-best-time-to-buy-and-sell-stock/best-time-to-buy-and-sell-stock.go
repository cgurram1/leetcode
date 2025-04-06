func maxProfit(prices []int) int {
    currMin := int(^uint(0) >> 1)
    result := 0
    for _,value := range prices{
        if value < currMin{
            currMin = value
        }
        if value - currMin > result{
            result = value - currMin
        } 
    }
    return result
}