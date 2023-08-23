package leetcode

private class `26_RemoveDuplicatesFromSortedArray` {
    fun removeDuplicates(nums: IntArray): Int {
        var idx = 1
        for (i in 1..nums.lastIndex) {
            if (nums[i-1] != nums[i]) {
                nums[idx++] = nums[i]
            }
        }

        return idx
    }
}