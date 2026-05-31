func hasDuplicate(nums []int) bool {
    seen := make(map[int]bool)
    for i := 0; i < len(nums); i++ {
        if _, hasSeen := seen[nums[i]]; hasSeen {
            return true
        }
        seen[nums[i]] = true
    }
    return false
}
